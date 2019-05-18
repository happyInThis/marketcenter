package com.zhao.marketcenter.action.impl.c;

import com.zhao.marketcenter.action.Action;
import com.zhao.marketcenter.action.ActionEnum;
import com.zhao.marketcenter.action.RequestContext;
import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.BaseResponse;
import com.zhao.marketcenter.action.util.ResponseUtil;
import com.zhao.marketcenter.dao.UserDAO;
import com.zhao.marketcenter.dao.entity.UserDO;
import com.zhao.marketcenter.dao.entity.UserQTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
@Log4j2
public class TestAction implements Action {

    @Resource
    private UserDAO userDAO;

    @Override
    public BaseResponse execute(RequestContext context) {
        UserQTO userQTO = (UserQTO) context.get("userQTO");
        List<UserDO> userDOs = userDAO.query(userQTO);
        List<UserDTO> userDTOS = new ArrayList<>();
        BeanUtils.copyProperties(userDOs, userDTOS);
        return ResponseUtil.getSuccessResponse(userDTOS);
    }

    @Override
    public String getName() {
        return ActionEnum.TEST.getActionName();
    }
}
