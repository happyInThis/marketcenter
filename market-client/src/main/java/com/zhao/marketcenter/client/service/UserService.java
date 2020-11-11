package com.zhao.marketcenter.client.service;

import com.zhao.marketcenter.client.BaseResponse;
import com.zhao.marketcenter.client.dto.UserDTO;

import java.util.List;


public interface UserService {

    BaseResponse<UserDTO> getUser(Long id);

    BaseResponse<List<UserDTO>> findUser(Long id);

    BaseResponse<Void> addUser(UserDTO userDTO);

}
