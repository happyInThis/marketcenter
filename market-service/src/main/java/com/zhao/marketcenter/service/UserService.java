package com.zhao.marketcenter.service;

import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.Response;
import com.zhao.marketcenter.dao.entity.QTO.UserQTO;

import java.util.List;


public interface UserService {

    Response<List<UserDTO>> test(UserQTO userQTO);

}
