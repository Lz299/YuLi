package com.xxxy.no2.model;

import java.io.Serializable;

public class Shoe implements Serializable {
    private int shoes_id;
    private String shoes_name;
    private String shoes_image;
    private User users;

    public Shoe() {
    }

    public Shoe(String shoes_name, String shoes_image, User users) {
        this.shoes_name = shoes_name;
        this.shoes_image = shoes_image;
        this.users = users;
    }

    public Shoe(int shoes_id, String shoes_name, String shoes_image) {
        this.shoes_id = shoes_id;
        this.shoes_name = shoes_name;
        this.shoes_image = shoes_image;
    }

    public Shoe(int shoes_id, String shoes_name, String shoes_image, User users) {
        this.shoes_id = shoes_id;
        this.shoes_name = shoes_name;
        this.shoes_image = shoes_image;
        this.users = users;
    }

    public int getShoes_id() {
        return shoes_id;
    }

    public void setShoes_id(int shoes_id) {
        this.shoes_id = shoes_id;
    }

    public String getShoes_name() {
        return shoes_name;
    }

    public void setShoes_name(String shoes_name) {
        this.shoes_name = shoes_name;
    }

    public String getShoes_image() {
        return shoes_image;
    }

    public void setShoes_image(String shoes_image) {
        this.shoes_image = shoes_image;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "shoes_id=" + shoes_id +
                ", shoes_name='" + shoes_name + '\'' +
                ", shoes_image='" + shoes_image + '\'' +
                ", users=" + users +
                '}';
    }
}
