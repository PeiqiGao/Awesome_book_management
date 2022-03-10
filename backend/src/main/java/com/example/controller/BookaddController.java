package com.example.controller;


import com.example.entity.Book;
import com.example.entity.Bookadd;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import com.example.service.BookService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addbook")
public class BookaddController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;



    @PostMapping
    public Integer save(Bookadd bookadd)
    {
        Book book = bookService.match(bookadd);
        if(book!=null)
        {
          bookMapper.available_possessionAdd(book.getName());
          return 1;
        }
        else
        {
            bookMapper.insert(bookadd.getName(),bookadd.getAuthor(),bookadd.getPrice(),bookadd.getPublishinghouse(),bookadd.getType());
            return 1;
        }

    }


}
