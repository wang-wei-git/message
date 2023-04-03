package com.ww.message.service;

import com.ww.message.mapper.UserMapper;
import com.ww.message.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
