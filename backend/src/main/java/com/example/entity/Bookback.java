package com.example.entity;


import lombok.Data;

@Data
public class Bookback {
    private String bookid;
    private String username;
    private String borrowtime;

    public String getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
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
