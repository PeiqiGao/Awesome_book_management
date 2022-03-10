package com.example.controller;


import com.example.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userdelete")
public class UserDeleteController {



    @Autowired
    private UserMapper userMapper;


    @PostMapping
    public Integer delete(@PathVariable String username)
    {
        return userMapper.deleteByusername(username);
    }

}
