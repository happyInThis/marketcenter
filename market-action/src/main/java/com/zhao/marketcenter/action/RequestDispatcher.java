package com.zhao.marketcenter.action;

import com.zhao.marketcenter.action.helper.BaseResponse;
import com.zhao.marketcenter.action.util.ResponseUtil;
import com.zhao.marketcenter.common.ResponseCode;
import com.zhao.marketcenter.common.exception.ServerException;
import com.zhao.marketcenter.common.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * 请求调度器
 */
@Service
public class RequestDispatcher {
    private Logger log = LoggerFactory.getLogger("accessLog");
    /**
     * 操作容器
     */
    @Resource
    private ActionHolder actionHolder;

    @Resource
    private AppContext appContext;

    public AppContext getAppContext() {
        return appContext;
    }

    public void setAppContext(AppContext appContext) {
        this.appContext = appContext;
    }

    public ActionHolder getActionHolder() {
        return actionHolder;
    }

    public void setActionHolder(ActionHolder actionHolder) {
        this.actionHolder = actionHolder;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public BaseResponse dispatch(ServerRequest req) {
        if(req == null) {
            throw new IllegalArgumentException("request is null!");
        }
        // 单例类限流措施
        ActionCall task = new ActionCall(req);
        BaseResponse response;
        try {
            response = task.call();
        } catch(ServerException se) {
            log.error("call exception code:{}", se.getResponseCode(), se.getMessage());
            return ResponseUtil.getErrorResponse(se.getResponseCode(), se.getMessage());
        } catch(Throwable e) {
            log.error("call exception", e);
            return ResponseUtil.getErrorResponse(ResponseCode.SYS_E_DEFAULT_ERROR);
        }
        return response;
    }


    private boolean allowAccess(Action action) {
        //TODO
        return true;
    }

    class ActionCall implements Callable<BaseResponse> {

        private ServerRequest req;

        public ActionCall(ServerRequest req) {
            super();
            this.req = req;
        }

        @Override
        public BaseResponse call() throws ServerException {

            // 查找具体的请求操作类型
            Action action = actionHolder.getAction(req.getCommand());
            if(null != action) {
                RequestContext context = new RequestContext(appContext, req);
                // set request here
                BaseResponse re;
                if(!allowAccess(action)) {
                    re = new BaseResponse(ResponseCode.SYS_E_DEFAULT_ERROR);
                    return re;
                }

                /**
                 * 以下时间变量用来统计整个执行过程中的filter.before,action以及filter.after的耗时
                 */
                long startTime = System.currentTimeMillis();
                long beforeFilterEndTime = 0L;
                long actionEndTime = 0L;
                long afterFilterEndTime = 0L;
                BaseResponse res = null;
                try {
                    // 执行操作
                    res = action.execute(context);
                    return res;
                } finally {
                    log.info("action:" + req.getCommand() + ", result:" + res.getCode() + ", filterBeforeCost:" + (beforeFilterEndTime - startTime) + ", actionCost:" + (actionEndTime - beforeFilterEndTime) + ", filterAfterCost:" + (afterFilterEndTime - actionEndTime));
                    log.info("request:{}", JsonUtil.toJson(req));
                    log.info("response:{}", JsonUtil.toJson(res));
                }
            } else {
                // 系统未建立相应的请求操作
                log.error("no action mapping for:" + req.getCommand());
                BaseResponse res = new BaseResponse(ResponseCode.PARAM_E_ACTION_NOT_EXIST);
                return res;
            }
        }

    }
}
