package com.example.mapper;


import com.example.entity.Book;
import com.example.entity.Paper;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface PaperMapper {



    @Insert("INSERT into paper(papername,author,papermag,paperpage) VALUES (#{papername},#{author},#{papermag},#{paperpage})")
    Integer insert ( @Param("papername") String papername, @Param("author") String author, @Param("papermag") String papermag, @Param("paperpage") Integer paperpage);

    @Select("select * from paper where paperid=#{paperid}")
    List<Paper> Selectbypaperid(@Param("paperid") Integer paperid);

    @Select("select * from paper where papername like concat('%',#{papername},'%')")
    List<Paper> Selectbypapername(@Param("papername") String papername);

    @Select("select * from paper where author=#{author}")
    List<Paper> Selectbyauthor(@Param("author") String author);

    @Select("select * from paper where papermag=#{papermag}")
    List<Paper> Selectbypapermag(@Param("papermag") String papermag);

    @Select("select * from paper")
    List<Paper> SelectAllpaper();

    @Delete(("delete  from paper where paperid=#{paperid}"))
    Integer paperdelete(@Param("paperid") Integer paperid);


  @Update("update paper set papername=#{papername},author=#{author},papermag=#{papermag},paperpage=#{paperpage}")
  Integer update(@Param("papername") String papername,@Param("author") String author,@Param("papermag") String papermag,  @Param("paperpage") Integer paperpage);


}
