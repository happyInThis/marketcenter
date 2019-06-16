package com.zhao.marketcenter.service.impl;

import com.zhao.marketcenter.action.ActionEnum;
import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.Request;
import com.zhao.marketcenter.action.helper.Response;
import com.zhao.marketcenter.action.util.RequestUtil;
import com.zhao.marketcenter.service.BaseService;
import com.zhao.marketcenter.service.UserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public Response<UserDTO> getUser(Long id) {
        Request request = RequestUtil.genRequest(ActionEnum.C_GET_USER);
        request.setParam("id", id);
        return execute(request);
    }

    @Override
    public Response<Void> addUser(UserDTO userDTO) {
        Request request = RequestUtil.genRequest(ActionEnum.C_ADD_USER);
        request.setParam("userDTO", userDTO);
        return execute(request);
    }

}
