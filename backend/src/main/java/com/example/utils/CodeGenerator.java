package com.example.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {

    public  static  void main(String[] args)

{

}

private void generate(){
    FastAutoGenerator.create("jdbc:postgresql://120.46.145.217:5432/postgres?serverTimezone=UTC&useUnicode=ture&characterEncoding=utf-8", "zky", "zzSS12345")
            .globalConfig(builder -> {
                builder.author("赵匡益") // 设置作者
                        .enableSwagger() // 开启 swagger 模式
                        .fileOverride() // 覆盖已生成文件
                        .outputDir("C:\\Users\\15911\\Desktop\\new\\src\\main\\java\\"); // 指定输出目录
            })
            .packageConfig(builder -> {
                builder.parent("com/example") // 设置父包名
                        .moduleName("") // 设置父包模块名
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C:\\Users\\15911\\Desktop\\new\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
            })
            .strategyConfig(builder -> {
                builder.addInclude("users") // 设置需要生成的表名
                        .addTablePrefix("t_", "c_"); // 设置过滤表前缀
            })

            .execute();
}
}
