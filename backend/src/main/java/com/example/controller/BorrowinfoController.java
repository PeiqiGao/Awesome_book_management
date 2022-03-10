package com.example.controller;


import com.example.entity.Borrowinfo;
import com.example.entity.Bookborrow;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrowinfo")
public class BorrowinfoController {

    @Autowired
    private UserMapper userMapper;





    @PostMapping
    public List<Bookborrow> userbook(Borrowinfo borrowinfo)
    {
//       int[] a=userMapper.querybookid(bookback.getUsername());

//        System.out.println(Arrays.toString(a));

        return userMapper.selectborrowinfoByusername(borrowinfo.getUsername());


    }


}
