package com.example.controller;


import com.example.entity.Book;
import com.example.entity.Bookadd;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookdelete")
public class BookDeleteController {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookService bookService;


    @PostMapping
    public Integer delete(Bookadd bookadd)
    {


        Book book = bookService.match(bookadd);
        if(book==null)
        {
            return 0;
        }
        else
        {
            bookMapper.deleteBybookname(bookadd.getName());
            return 1;
        }

    }




}
