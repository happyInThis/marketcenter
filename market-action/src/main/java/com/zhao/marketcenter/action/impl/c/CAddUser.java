package com.zhao.marketcenter.action.impl.c;

import com.zhao.marketcenter.action.Action;
import com.zhao.marketcenter.action.ActionEnum;
import com.zhao.marketcenter.action.RequestContext;
import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.BaseResponse;
import com.zhao.marketcenter.action.util.ResponseUtil;
import com.zhao.marketcenter.common.exception.ServerException;
import com.zhao.marketcenter.dao.entity.DO.UserDO;
import com.zhao.marketcenter.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
@Slf4j
public class CAddUser implements Action {

    @Resource
    private UserManager userManager;

    @Override
    public BaseResponse execute(RequestContext context) {
        UserDTO userDTO = (UserDTO) context.getRequest().getParam("userDTO");
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);
        try {
            userManager.add(userDO);
            return ResponseUtil.getSuccessResponse();
        } catch (ServerException e) {
            return ResponseUtil.getErrorResponse(e);
        }
    }

    @Override
    public String getName() {
        return ActionEnum.C_ADD_USER.getActionName();
    }
}
