package com.springboot.service;

import com.springboot.bean.User;

public interface UserService {
    public User getUserByUsername(String username);
}
