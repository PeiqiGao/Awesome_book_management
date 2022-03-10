package com.example.controller;


import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userregist")
public class UserRegistController {

 @Autowired
 private UserService userService;
 @Autowired
 private UserMapper userMapper;


    @PostMapping
    public  Integer save(User user)
    {

        User user1=userMapper.queryUserByName(user.getUsername());
        if(user1!=null)
        {
            return 0;
        }
        else{
            userMapper.insert(user);
            return 1;
        }

    }


}
