package com.example.service;


import com.example.entity.Book;
import com.example.entity.Bookadd;
import com.example.entity.User;
import com.example.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;


    public Book match(Bookadd bookadd)
    {
        return bookMapper.queryBookBy5(bookadd.getName(),bookadd.getAuthor(),bookadd.getPublishinghouse(),bookadd.getPrice(),bookadd.getType());
    }


}
