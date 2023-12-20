package com.xxxy.no2.model;

public class Like {
    private int likes_id;
    private Users users;
    private Posts post;

    public Like() {
    }

    public int getLikes_id() {
        return likes_id;
    }

    public void setLikes_id(int likes_id) {
        this.likes_id = likes_id;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
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
                ", user=" + users +
                ", post=" + post +
                '}';
    }
}
