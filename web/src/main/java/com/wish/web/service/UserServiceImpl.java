package com.wish.web.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.wish.mapper.TestMapper;
import com.wish.web.remote.TestRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private TestRemote testRemote;

    @Autowired
    private TestMapper testMapper;

    @Override
    @LcnTransaction //分布式事务注解
    public void testTxlcn1() {
        testMapper.insert("张三");

        testRemote.addUser("李四");

    }

    @Override
    @LcnTransaction //分布式事务注解
    public void testTxlcn2() {

        testRemote.addUser("李四");
        throw new RuntimeException("");
    }
}
