package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor

@Data
public class Paper {

    private String  paperid;
    private String papername;
    private  String author;

    private String papermag;
    private String select;
    private Integer paperpage;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }




    public Integer  getPaperid() {
        return Integer.parseInt(paperid);
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPapermag() {
        return papermag;
    }

    public void setPapermag(String papermag) {
        this.papermag = papermag;
    }

    public Integer getPaperpage() {
        return paperpage;
    }

    public void setPaperpage(Integer paperpage) {
        this.paperpage = paperpage;
    }
}
