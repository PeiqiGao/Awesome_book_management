package com.example.controller;


import com.example.entity.Book;
import com.example.entity.Booksearch;
import com.example.entity.User;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SelectController {

    @Autowired
    private BookMapper bookMapper;


    @PostMapping
    public List<Book> Selectbyname(Booksearch booksearch){
         if(booksearch.getSelect().equals("bookname") ){
        return bookMapper.Selectbyname(booksearch.getName());}
         else if(booksearch.getSelect().equals("bookid"))
         {
             return bookMapper.Selectbybookid(booksearch.getName());
         }
         else if(booksearch.getSelect().equals("author")){
             return bookMapper.Selectbyauthor(booksearch.getName());
         }
         else if(booksearch.getSelect().equals("all"))
         {
             return bookMapper.SelectAll();
         }
         else{
             return bookMapper.Selectbybookshelf_type(booksearch.getName());
         }

    }


}
