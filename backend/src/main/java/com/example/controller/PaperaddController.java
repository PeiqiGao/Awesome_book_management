package com.example.controller;


import com.example.entity.Paper;
import com.example.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paperadd")
public class PaperaddController {



    @Autowired
    private PaperMapper paperMapper;

    @PostMapping
    public Integer paperadd(Paper paper)
    {
        paperMapper.insert(paper.getPapername(),paper.getAuthor(),paper.getPapermag(),paper.getPaperpage());
        return 1;

    }


}
