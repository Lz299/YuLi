package com.xxxy.no2.model;

public class Like {
    private int id;
    private User user;
    private Posts post;


    public Like(int id, User user, Posts post) {
        this.id = id;
        this.user = user;
        this.post = post;
    }

    public Like() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }


    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
