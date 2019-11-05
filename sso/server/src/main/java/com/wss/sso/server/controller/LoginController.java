package com.wss.sso.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author wangshasha
 * @Date 2019-11-05 16:04
 * @Version
 */
@Controller
public class LoginController {
    /**
     * 自定义登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
