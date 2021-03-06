package com.springboot.service.impl;


import com.springboot.bean.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
