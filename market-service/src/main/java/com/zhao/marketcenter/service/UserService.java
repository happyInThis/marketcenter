package com.zhao.marketcenter.service;

import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.Response;


public interface UserService {

    Response<UserDTO> getUser(Long id);

    Response<Void> addUser(UserDTO userDTO);

}
