package com.wish.web.controller;

import com.wish.common.model.ResponseBean;
import com.wish.service.TestService;
import com.wish.web.remote.TestRemote;
import com.wish.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wish on 2019/3/2.
 */
@RestController
public class TestController {

    @Autowired
    TestRemote testRemote;

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return testRemote.hello(name);
    }

    @RequestMapping("/hello2")
    public String index2(@RequestParam String name) {
        return testRemote.hello2(name);
    }

    @RequestMapping("/hello3")
    public ResponseBean index3(@RequestParam String name) {
        return ResponseBean.successResponse(name);
    }


    @RequestMapping("/testTxlcn1")
    public void testTxlcn1() {
        userService.testTxlcn1();
    }

    @RequestMapping("/testTxlcn2")
    public void testTxlcn2() {
        userService.testTxlcn2();
    }

}
