package com.example.controller;


import com.example.entity.Book;
import com.example.entity.Bookadd;
import com.example.entity.Bookborrow;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrowbook")
public class BookBorrowController {


    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public Integer borrow(Bookborrow bookborrow) {
        if (bookMapper.Selectavailable(bookborrow.getBookid()).getAvailable().equals(0)) {
            return 0;
        } else {
            bookMapper.availableSubtract(bookborrow.getBookid());
            userMapper.addbook(bookborrow.getBookid(), bookborrow.getUsername());
            userMapper.insertborrowinfo(bookborrow.getUsername(),bookborrow.getBookname(),bookborrow.getBookid());
            return 1;

        }

    }
}