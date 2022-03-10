package com.example.controller;


import com.example.entity.Book;
import com.example.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookchange")
public class BookChangeController {



    @Autowired
    private BookMapper bookMapper;



    @PostMapping
    public Integer update(Book book)
    {
         bookMapper.update(book.getName(),book.getAuthor(),book.getAvailable(),book.getPossession(),book.getPrice(),book.getPublishinghouse(),book.getType(),book.getId());
         return 1;


    }

}
