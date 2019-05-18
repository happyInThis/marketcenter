package com.zhao.marketcenter.api;

import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.Response;
import com.zhao.marketcenter.action.util.ResponseUtil;
import com.zhao.marketcenter.common.util.JsonUtil;
import com.zhao.marketcenter.dao.entity.UserQTO;
import com.zhao.marketcenter.entity.UserVO;
import com.zhao.marketcenter.service.CommonService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CommonApi {
    @Resource
    private CommonService commonService;


    /**
     * 测试
     * @param id
     * @return
     */
    @RequestMapping("/test/get")
    public String testGet(@RequestParam(value = "id") Long id) {

        UserQTO userQTO = new UserQTO();
        userQTO.setId(id);
        Response<List<UserDTO>> response = commonService.test(userQTO);
        if(response.isSuccess()) {
            List<UserVO> userVos = new ArrayList<>();
            BeanUtils.copyProperties(response.getModule(), userVos);
            return JsonUtil.toJson(ResponseUtil.getSuccessResponse(userVos, userVos.size()));
        }
        return JsonUtil.toJson(ResponseUtil.getErrorResponse(response.getCode(), response.getMsg()));
    }

    /**
     * 校验本地服务器的启动状态
     * @return
     */
    @RequestMapping("/server/status/check")
    public String checkServerStatus() {
        return "success";
    }

}