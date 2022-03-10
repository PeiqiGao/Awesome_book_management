package com.example.controller;


import com.example.entity.User;
import com.example.entity.Userlogin;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;






    //登录
    @PostMapping
    public  Integer login(Userlogin userlogin)
    {
        User queryUser = userService.login(userlogin);

        if (queryUser == null){
            return 404;
        }else {
            return 200;
        }


    }

}
