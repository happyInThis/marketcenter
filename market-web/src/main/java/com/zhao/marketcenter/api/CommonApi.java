package com.zhao.marketcenter.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonApi {

    /**
     * 校验本地服务器的启动状态
     *
     * @return
     */
    @RequestMapping("/server/status/check")
    public String checkServerStatus() {
        return "success";
    }

}