package com.wish.web.controller;

import com.wish.web.remote.TestRemote;
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

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return testRemote.hello(name);
    }

    @RequestMapping("/hello2")
    public String index2(@RequestParam String name) {
        return testRemote.hello2(name);
    }

}
