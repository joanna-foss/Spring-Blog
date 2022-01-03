package com.codeup.springblog.controllers;

public class Post {
    private String title;
    private int id;
    private String body;

    public Post(){};

    public Post(String title, int id, String body){
        this.title = title;
        this.id = id;
        this.body = body;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}