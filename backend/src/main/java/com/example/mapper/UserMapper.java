package com.example.mapper;

import com.example.entity.Book;
import com.example.entity.Bookborrow;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.lang.reflect.Array;
import java.util.List;

@Mapper
public interface UserMapper {

        @Select("SELECT * from users")
        List<User> findALL();


        @Select("select * from users where username=#{username} and password=#{password} and type=#{type}")
        User queryUser(@Param("username") String username,@Param("password") String password,@Param("type") String type);

        @Select("select * from users where username=#{username} ")
        User queryUserByName(@Param("username") String username);

        @Insert("INSERT into users(username,password,gender,type) VALUES (#{username},#{password},#{gender},#{type})")
        int insert(User user);

        @Update("update users set bookid = array_append(bookid,#{id})  where username=#{username}")
        Integer addbook(@Param("id") Integer id, @Param("username") String username);

//        @Select("select bookid from users where username=#{username}")
//       int [] querybookid(@Param("username") String username);

        @Insert("insert into borrowinfo(username,bookname,bookid) VALUES(#{username},#{bookname},#{bookid})")
        Integer insertborrowinfo(@Param("username") String username,@Param("bookname") String bookname,@Param("bookid") Integer bookid);


        @Select("select * from borrowinfo  where username=#{username}")
        List<Bookborrow> selectborrowinfoByusername(@Param("username") String username);

        @Delete("delete from borrowinfo where username=#{username} and bookid=#{bookid} and borrowtime=#{borrowtime}")
        Integer deleteBorrowinfo(@Param("username") String username,@Param("bookid") Integer bookid, @Param("borrowtime") String borrowtime);


        int update(User user);


        @Delete("delete from users where username= #{username}")
        Integer deleteByusername(@Param("username") String username);
}
