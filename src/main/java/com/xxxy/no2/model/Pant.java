package com.xxxy.no2.model;

import java.io.Serializable;

public class Pant implements Serializable {
    private int pants_id;
    private String pants_name;
    private String pants_image;
    private Users users;

    public Pant() {
    }

    public Pant(String pants_name, String pants_image, Users users) {
        this.pants_name = pants_name;
        this.pants_image = pants_image;
        this.users = users;
    }

    public Pant(int pants_id, String pants_name, String pants_image) {
        this.pants_id = pants_id;
        this.pants_name = pants_name;
        this.pants_image = pants_image;
    }

    public Pant(int pants_id, String pants_name, String pants_image, Users users) {
        this.pants_id = pants_id;
        this.pants_name = pants_name;
        this.pants_image = pants_image;
        this.users = users;
    }

    public int getPants_id() {
        return pants_id;
    }

    public void setPants_id(int pants_id) {
        this.pants_id = pants_id;
    }

    public String getPants_name() {
        return pants_name;
    }

    public void setPants_name(String pants_name) {
        this.pants_name = pants_name;
    }

    public String getPants_image() {
        return pants_image;
    }

    public void setPants_image(String pants_image) {
        this.pants_image = pants_image;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Pants{" +
                "pants_id=" + pants_id +
                ", pants_name=" + pants_name +
                ", pants_image=" + pants_image +
                ", users=" + users +
                '}';
    }
}
