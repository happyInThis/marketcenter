package com.zhao.marketcenter.service.impl;

import com.zhao.marketcenter.action.ActionEnum;
import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.Request;
import com.zhao.marketcenter.action.helper.Response;
import com.zhao.marketcenter.action.util.RequestUtil;
import com.zhao.marketcenter.dao.entity.UserQTO;
import com.zhao.marketcenter.service.BaseService;
import com.zhao.marketcenter.service.CommonService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("commonService")
public class CommonServiceImpl extends BaseService implements CommonService {

    @Override
    public Response<List<UserDTO>> test(UserQTO userQTO) {
        Request request = RequestUtil.genRequest(ActionEnum.TEST);
        request.setParam("userQTO", userQTO);
        return execute(request);
    }

}
