package com.zhao.marketcenter.action.impl.c;

import com.zhao.marketcenter.action.Action;
import com.zhao.marketcenter.action.ActionEnum;
import com.zhao.marketcenter.action.RequestContext;
import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.BaseResponse;
import com.zhao.marketcenter.action.util.ResponseUtil;
import com.zhao.marketcenter.dao.DAO.UserDAO;
import com.zhao.marketcenter.dao.entity.DO.UserDO;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
@Slf4j
public class CGetUser implements Action {

    @Resource
    private UserDAO userDAO;

    @Override
    public BaseResponse execute(RequestContext context) {
        Long id = (Long) context.getRequest().getParam("id");
        UserDO userDO = userDAO.get(id);
        UserDTO userDTO = new UserDTO();
        if (userDO != null) {
            BeanUtils.copyProperties(userDO, userDTO);
            return ResponseUtil.getSuccessResponse(userDTO);
        }
        return ResponseUtil.getSuccessResponse();
    }

    @Override
    public String getName() {
        return ActionEnum.C_GET_USER.getActionName();
    }
}
