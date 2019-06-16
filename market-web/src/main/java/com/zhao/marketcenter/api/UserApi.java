package com.zhao.marketcenter.api;

import com.zhao.marketcenter.action.entity.dto.UserDTO;
import com.zhao.marketcenter.action.helper.Response;
import com.zhao.marketcenter.action.util.ResponseUtil;
import com.zhao.marketcenter.common.util.JsonUtil;
import com.zhao.marketcenter.entity.VO.UserVO;
import com.zhao.marketcenter.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserApi {
    @Resource
    private UserService userService;

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/user/get")
    public String getUser(@RequestParam(value = "id") Long id) {

        Response<UserDTO> response = userService.getUser(id);
        if (response.isSuccess()) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(response.getModule(), userVO);
            return JsonUtil.toJson(ResponseUtil.getSuccessResponse(userVO, 1));
        }
        return JsonUtil.toJson(ResponseUtil.getErrorResponse(response.getCode(), response.getMsg()));
    }

    /**
     * 查询用户
     *
     * @param userName
     * @param age
     * @return
     */
    @RequestMapping("/user/add")
    public String addUser(@RequestParam(value = "user_name") String userName, @RequestParam(value = "age") Integer age) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userName);
        userDTO.setAge(age);
        Response<Void> response = userService.addUser(userDTO);
        if (response.isSuccess()) {
            return JsonUtil.toJson(ResponseUtil.getSuccessResponse());
        }
        return JsonUtil.toJson(ResponseUtil.getErrorResponse(response.getCode(), response.getMsg()));
    }
}