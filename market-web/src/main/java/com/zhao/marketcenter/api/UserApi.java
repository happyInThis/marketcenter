package com.zhao.marketcenter.api;

import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.Response;
import com.zhao.marketcenter.action.util.ResponseUtil;
import com.zhao.marketcenter.common.util.JsonUtil;
import com.zhao.marketcenter.dao.entity.QTO.UserQTO;
import com.zhao.marketcenter.entity.VO.UserVO;
import com.zhao.marketcenter.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserApi {
    @Resource
    private UserService userService;

    /**
     * 测试
     *
     * @param id
     * @return
     */
    @RequestMapping("/test/get")
    public String testGet(@RequestParam(value = "id") Long id) {

        UserQTO userQTO = new UserQTO();
        userQTO.setId(id);
        userQTO.setCount(10);
        userQTO.setOffset(0);
        Response<List<UserDTO>> response = userService.test(userQTO);
        if (response.isSuccess()) {
            List<UserVO> userVos = new ArrayList<>();
            response.getModule().forEach(userDTO -> {
                UserVO userVO = new UserVO();
                BeanUtils.copyProperties(userDTO, userVO);
                userVos.add(userVO);
            });
            return JsonUtil.toJson(ResponseUtil.getSuccessResponse(userVos, userVos.size()));
        }
        return JsonUtil.toJson(ResponseUtil.getErrorResponse(response.getCode(), response.getMsg()));
    }
}