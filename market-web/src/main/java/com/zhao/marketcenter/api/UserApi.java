package com.zhao.marketcenter.api;

import com.zhao.marketcenter.client.BaseResponse;
import com.zhao.marketcenter.client.dto.UserDTO;
import com.zhao.marketcenter.client.service.UserService;
import com.zhao.marketcenter.common.UserVO;
import com.zhao.marketcenter.common.util.BeanConvertBasic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    public BaseResponse getUser(@RequestParam(value = "id") Long id) {

        BaseResponse response = userService.getUser(id);
        if (response.isSuccess()) {
            if (response.getData() != null) {
                UserVO userVO = BeanConvertBasic.INSTANCE.dto2vo((UserDTO) response.getData());
                response.setData(userVO);
                return response;
            }
            return response;
        }
        return response;
    }

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/user/find")
    public BaseResponse findUser(@RequestParam(value = "id") Long id) {

        BaseResponse response = userService.findUser(id);
        if (response.isSuccess()) {
            if (response.getData() != null) {
                List<UserVO> userVOList = BeanConvertBasic.INSTANCE.dtoList2voList((List<UserDTO>) response.getData());
                response.setData(userVOList);
                return response;
            }
            return response;
        }
        return response;
    }

    /**
     * 新增用户
     *
     * @param userName
     * @param age
     * @return
     */
    @RequestMapping("/user/add")
    public BaseResponse addUser(@RequestParam(value = "user_name") String userName, @RequestParam(value = "age") Integer age) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userName);
        userDTO.setAge(age);
        return userService.addUser(userDTO);
    }
}