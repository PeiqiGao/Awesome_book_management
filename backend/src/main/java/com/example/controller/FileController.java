package com.example.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.entity.Paper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/file")
public class FileController {




    @Value("${files.upload.path}")
    private String fileUploadPath;



//    文件上传接口
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException

    {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName((originalFilename));
        long size = file.getSize();


        //先存储到磁盘
        File uploadParentFile = new File(fileUploadPath);
        //判断配置文件目录是否存在，不存在则创建新的
        if(!uploadParentFile.exists())
        {
            uploadParentFile.mkdir();
        }
        //定义一个文件唯一标识码
        String uuid = IdUtil.fastSimpleUUID();
        File uploadFile = new File(fileUploadPath+uuid+ StrUtil.DOT + type);
        //把获取的文件存储到磁盘目录
        file.transferTo(uploadFile);


        String url="http://localhost:8080/"+uuid;
        //存储数据库
        Paper saveFile =new Paper();
        saveFile.setUrl(url);

        return url;




    }



}
