package com.example.mapper;


import com.example.entity.Book;
import com.example.entity.Bookadd;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {


    @Select("select * from books")
    List<Book> SelectAll();


    @Select("select * from books where name like concat('%',#{name},'%')")
    List<Book> Selectbyname(@Param("name") String name);

    @Select("select * from books where bookid=#{bookid}")
    List<Book> Selectbybookid(@Param("bookid") String bookid);

    @Select("select * from books where author=#{author}")
    List<Book> Selectbyauthor(@Param("author") String author);

    @Select("select * from books where type=#{type}")
    List<Book> Selectbybookshelf_type(@Param("type") String type);

    @Select("select * from books where bookid=#{bookid}")
    Book Selectavailable(@Param("bookid") Integer bookid);

    @Select("select * from books where name=#{name} and author=#{author} and publishinghouse=#{publishinghouse} and price=#{price} and type=#{type}")
    Book queryBookBy5(@Param("name") String name,@Param("author") String author,@Param("publishinghouse") String publishinghouse, @Param("price") Integer price,@Param("type")String type);

    @Update("update books set available=available+1,possession=possession+1 where name=#{name}" )
    Integer available_possessionAdd(@Param("name") String  name);

    @Update("update books set available=available+1 where bookid=#{bookid}" )
    Integer availableAdd(@Param("bookid") Integer  bookid);

    @Update("update books set available=available-1 where bookid=#{bookid}")
    Integer availableSubtract(@Param("bookid") Integer bookid);

    @Update("update books set name=#{name},author=#{author},available=#{available},possession=#{possession},price=#{price},publishinghouse=#{publishinghouse},type=#{type} where bookid=#{bookid}")
    Integer update(@Param("name") String name,@Param("author") String author,@Param("available") Integer available,@Param("possession") Integer possession,  @Param("price") Integer price,@Param("publishinghouse") String publishinghouse,@Param("type")String type,@Param("bookid")Integer bookid);
    @Insert("INSERT into books(name,author,available,possession,price,publishinghouse,type) VALUES (#{name},#{author},'1','1',#{price},#{publishinghouse},#{type})")
    Integer insert (@Param("name") String name, @Param("author") String author, @Param("price") Integer price, @Param("publishinghouse") String publishinghouse,@Param("type") String type);


    @Delete("delete from books where name= #{name}")
    Integer deleteBybookname(@Param("name") String name);

}
