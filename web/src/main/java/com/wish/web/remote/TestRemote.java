package com.wish.web.remote;

import com.wish.web.hystrix.TestRemoteHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wish on 2019/3/2.
 */
@FeignClient(name= "api", fallback = TestRemoteHystric.class)
public interface TestRemote {
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hello2")
    String hello2(@RequestParam(value = "name") String name);
}
