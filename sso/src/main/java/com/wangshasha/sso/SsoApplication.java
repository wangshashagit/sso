package com.wangshasha.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//启动类添加 @EnableResourceServer 注解，表示作为资源服务器。
@SpringBootApplication
@EnableResourceServer
public class SsoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }

}
