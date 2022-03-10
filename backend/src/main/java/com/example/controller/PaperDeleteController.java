package com.example.controller;


import com.example.entity.Paper;
import com.example.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paperdelete")
public class PaperDeleteController {


    @Autowired
    private PaperMapper paperMapper;

    @PostMapping
    public Integer paperdelete(Paper paper)
    {
        paperMapper.paperdelete(paper.getPaperid());
        return 1;
    }
}
