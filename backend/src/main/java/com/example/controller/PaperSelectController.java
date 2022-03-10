package com.example.controller;


import com.example.entity.Book;
import com.example.entity.Booksearch;
import com.example.entity.Paper;
import com.example.mapper.BookMapper;
import com.example.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/papersearch")

public class PaperSelectController {



    @Autowired
    private PaperMapper paperMapper;


    @PostMapping
    public List<Paper> Selectbypaperid(Paper paper){

        if(paper.getSelect().equals("paperid") )
        {
            return paperMapper.Selectbypaperid(paper.getPaperid());
        }


        else if(paper.getSelect().equals("papername"))
        {
            return paperMapper.Selectbypapername(paper.getPapername());
        }


        else if(paper.getSelect().equals("author"))
        {
            return paperMapper.Selectbyauthor(paper.getAuthor());
        }


        else if(paper.getSelect().equals("papermag"))
        {
            return  paperMapper.Selectbypapermag(paper.getPapermag());
        }

        else
        {
            return paperMapper.SelectAllpaper();
        }


    }




}
