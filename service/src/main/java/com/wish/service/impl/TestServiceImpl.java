package com.wish.service.impl;

import com.wish.mapper.TestMapper;
import com.wish.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public void addUser(String name) {
        testMapper.insert(name);
    }


}
