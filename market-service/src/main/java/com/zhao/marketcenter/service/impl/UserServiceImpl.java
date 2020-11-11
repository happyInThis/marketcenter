package com.zhao.marketcenter.service.impl;

import com.zhao.marketcenter.client.BaseResponse;
import com.zhao.marketcenter.client.dto.UserDTO;
import com.zhao.marketcenter.client.service.UserService;
import com.zhao.marketcenter.common.exception.ServerException;
import com.zhao.marketcenter.common.util.BeanConvertBasic;
import com.zhao.marketcenter.dao.entity.DO.UserDO;
import com.zhao.marketcenter.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Slf4j
//@DubboService(timeout = 5000,version="1.0.0",interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserManager userManager;

    @Override
    public BaseResponse<UserDTO> getUser(Long id) {
//        try {
//            userManager.get(id);
//        } catch (ServerException e) {
//            log.error("", e);
//        }
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(11);
        userDTO.setUserName("赵");
        userDTO.setMobile("1234234234");
        return new BaseResponse<>(userDTO);
    }

    @Override
    public BaseResponse<List<UserDTO>> findUser(Long id) {
//        try {
//            userManager.get(id);
//        } catch (ServerException e) {
//            log.error("", e);
//        }
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(11);
        userDTO.setUserName("赵");
        userDTO.setMobile("1234234234");
        return new BaseResponse<>(Arrays.asList(userDTO));
    }

    @Override
    public BaseResponse<Void> addUser(UserDTO userDTO) {
        UserDO userDO = BeanConvertBasic.INSTANCE.dto2do(userDTO);
        try {
            userManager.add(userDO);
        } catch (ServerException e) {
            log.error("", e);
        }
        return new BaseResponse<>();
    }

}
