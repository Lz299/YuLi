package com.xxxy.no2.model;

public class Comments {
    private int comments_id;
    private String comments_content;
    private User users;
    private Posts posts;

    public Comments() {
    }

    public int getComments_id() {
        return comments_id;
    }

    public void setComments_id(int comments_id) {
        this.comments_id = comments_id;
    }

    public String getComments_content() {
        return comments_content;
    }

    public void setComments_content(String comments_content) {
        this.comments_content = comments_content;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comments_id=" + comments_id +
                ", comments_content='" + comments_content + '\'' +
                ", users=" + users +
                ", posts=" + posts +
                '}';
    }
}
