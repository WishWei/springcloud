package com.wish.api.controller;

import com.wish.component.DistributedLockByCurator;
import com.wish.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wish on 2019/3/2.
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private DistributedLockByCurator distributedLockByCurator;

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello "+name+"，this is first messge";
    }

    @RequestMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "hello2 "+name+"，this is first messge";
    }

    @RequestMapping("/testLock")
    public String testLock(@RequestParam String lockName) throws Exception{
        distributedLockByCurator.acquireDistributedLock(lockName);
        log.info("thread:{} acquired lock:{}", Thread.currentThread().getName(), lockName);
        Thread.sleep(5000);
        distributedLockByCurator.releaseDistributedLock(lockName);
        log.info("thread:{} released lock:{}", Thread.currentThread().getName(), lockName);
        return "lockName "+lockName;
    }

    @GetMapping("/addUser")
    public void addUser(String name){
        testService.addUser(name);
    }
}