package com.example.multisource.service.user.impl;

import com.example.multisource.dao.user.UserMapper;
import com.example.multisource.domain.User;
import com.example.multisource.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
