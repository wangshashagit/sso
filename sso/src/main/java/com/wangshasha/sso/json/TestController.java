package com.wangshasha.sso.json;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author wangshasha
 * @Date 2019-11-01 15:13
 * @Version
 */
@RestController
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "hello springBoot";
    }

}
