package com.example.service;



import com.example.entity.User;
import com.example.entity.Userlogin;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;



    public User login(Userlogin userlogin)
    {
        return userMapper.queryUser(userlogin.getUsername(),userlogin.getPassword(),userlogin.getType());
    }

}
