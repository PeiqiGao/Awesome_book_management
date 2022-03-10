package com.example.entity;


import lombok.Data;

@Data
public class Book
{
    private String  bookid;
    private String name;
    private String author;
    private Integer available;
    private Integer possession;
    private  Integer price;
    private String publishinghouse;
    private  String type;



    public Integer getId() {
        return  Integer.parseInt(bookid);
    }

    public void setId(String bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getPossession() {
        return possession;
    }

    public void setPossession(Integer possession) {
        this.possession = possession;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPublishinghouse() {
        return publishinghouse;
    }

    public void setPublishinghouse(String publishinghouse) {
        this.publishinghouse = publishinghouse;}
}
