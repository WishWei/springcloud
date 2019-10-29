package com.wish.web.hystrix;

import com.wish.web.remote.TestRemote;
import org.springframework.stereotype.Component;

/**
 * Created by wish on 2019/3/2.
 */
@Component
public class TestRemoteHystric implements TestRemote {
    @Override
    public String hello(String name) {
        return "hello" +name+", this messge send failed ";
    }

    @Override
    public String hello2(String name) {
        return "hello2" +name+", this messge send failed ";
    }

    @Override
    public String addUser(String name) {
        return "addUser" +name+", this messge send failed ";
    }
}
