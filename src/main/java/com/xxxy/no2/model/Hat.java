package com.xxxy.no2.model;

import java.io.Serializable;

public class Hat implements Serializable {
    private int hats_id;
    private String hats_name;
    private String hats_image;
    private Users users;

    public Hat() {
    }

    public Hat(String hats_name, String hats_image, Users users) {
        this.hats_name = hats_name;
        this.hats_image = hats_image;
        this.users = users;
    }

    public Hat(int hats_id, String hats_name, String hats_image) {
        this.hats_id = hats_id;
        this.hats_name = hats_name;
        this.hats_image = hats_image;
    }

    public Hat(int hats_id, String hats_name, String hats_image, Users users) {
        this.hats_id = hats_id;
        this.hats_name = hats_name;
        this.hats_image = hats_image;
        this.users = users;
    }

    public int getHats_id() {
        return hats_id;
    }

    public void setHats_id(int hats_id) {
        this.hats_id = hats_id;
    }

    public String getHats_name() {
        return hats_name;
    }

    public void setHats_name(String hats_name) {
        this.hats_name = hats_name;
    }

    public String getHats_image() {
        return hats_image;
    }

    public void setHats_image(String hats_image) {
        this.hats_image = hats_image;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Hat{" +
                "hats_id=" + hats_id +
                ", hats_name='" + hats_name + '\'' +
                ", hats_image='" + hats_image + '\'' +
                ", users=" + users +
                '}';
    }
}
