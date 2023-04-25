package com.example.publicblog.entities;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;

public class Blog {

    private Integer id;
    @NotNull(message = "Author of the blog is required!")
    private String author;
    @NotNull(message = "Title of the blog is required!")
    private String title;
    @NotNull(message = "Content of the blog is required!")
    private String content;

    private String date;

    private ArrayList<Comment> comments;

    public Blog(){
    }

    public Blog(String author, String title, String content) {
        this();
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = "";
        this.comments = new ArrayList<>();
    }

    public Blog(Integer id, String author, String title, String content, String date){
        this(author, title, content);
        this.id = id;
        this.date = date;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
}
