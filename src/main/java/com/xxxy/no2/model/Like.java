package com.xxxy.no2.model;

public class Like {
    private int likes_id;
    private User user;
    private Posts post;

    public Like() {
    }

    public int getLikes_id() {
        return likes_id;
    }

    public void setLikes_id(int likes_id) {
        this.likes_id = likes_id;
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
                "likes_id=" + likes_id +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
