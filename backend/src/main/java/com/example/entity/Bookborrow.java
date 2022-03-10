package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bookborrow {

    private String bookid;
    private String username;
    private String borrowtime;
    private String bookname;


    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBookid() {

        return Integer.parseInt(bookid);
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
