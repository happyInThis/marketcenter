package com.zhao.marketcenter.action.impl.c;

import com.zhao.marketcenter.action.Action;
import com.zhao.marketcenter.action.ActionEnum;
import com.zhao.marketcenter.action.RequestContext;
import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.BaseResponse;
import com.zhao.marketcenter.action.util.ResponseUtil;
import com.zhao.marketcenter.dao.DAO.UserDAO;
import com.zhao.marketcenter.dao.entity.DO.UserDO;
import com.zhao.marketcenter.dao.entity.QTO.UserQTO;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
@Slf4j
public class CQueryUser implements Action {

    @Resource
    private UserDAO userDAO;

    @Override
    public BaseResponse execute(RequestContext context) {
        UserQTO userQTO = (UserQTO) context.getRequest().getParam("userQTO");
        List<UserDO> userDOs = userDAO.query(userQTO);
        List<UserDTO> userDTOS = new ArrayList<>();
        userDOs.forEach(userDO -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userDO, userDTO);
            userDTOS.add(userDTO);
        });
        return ResponseUtil.getSuccessResponse(userDTOS);
    }

    @Override
    public String getName() {
        return ActionEnum.C_QUERY_USER.getActionName();
    }
}
