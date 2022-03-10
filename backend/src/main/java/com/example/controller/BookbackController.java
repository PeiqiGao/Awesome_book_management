package com.example.controller;


import com.example.entity.Book;
import com.example.entity.Bookback;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookback")
public class BookbackController {


    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

@PostMapping
    public Integer bookback(Bookback bookback)
{
    userMapper.deleteBorrowinfo(bookback.getUsername(),bookback.getBookid(),bookback.getBorrowtime());
    bookMapper.availableAdd(bookback.getBookid());
    return 1;
}




}
