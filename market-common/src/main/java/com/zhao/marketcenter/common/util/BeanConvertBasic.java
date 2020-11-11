package com.zhao.marketcenter.common.util;


import com.zhao.marketcenter.client.dto.UserDTO;
import com.zhao.marketcenter.common.UserVO;
import com.zhao.marketcenter.dao.entity.DO.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BeanConvertBasic {
    BeanConvertBasic INSTANCE = Mappers.getMapper(BeanConvertBasic.class);

    UserDO dto2do(UserDTO userDTO);

    UserDTO do2dto(UserDO userDO);

    UserVO dto2vo(UserDTO userDTO);

    List<UserVO> dtoList2voList(List<UserDTO> userDTOList);
}
