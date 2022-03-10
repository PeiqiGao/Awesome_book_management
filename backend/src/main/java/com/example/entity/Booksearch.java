package com.example.entity;

import lombok.Data;

@Data
public class Booksearch {
    private String name;

    private String select;



    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
