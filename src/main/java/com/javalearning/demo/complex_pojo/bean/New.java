package com.javalearning.demo.complex_pojo.bean;

import java.io.Serializable;
import java.util.Date;

public class New implements Serializable {

    private String author;
    private String content;
    private Date date;

    public New(String author, String content, Date date) {
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "New{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
