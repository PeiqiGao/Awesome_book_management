package com.example.controller;

import com.example.entity.Book;
import com.example.entity.Paper;
import com.example.mapper.BookMapper;
import com.example.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/paperchange")
public class PaperChangeController {



        @Autowired
        private PaperMapper paperMapper;



        @PostMapping
        public Integer update(Paper paper)
        {
            paperMapper.update(paper.getPapername(),paper.getAuthor(),paper.getPapermag(),paper.getPaperpage());
            return 1;




    }




}
