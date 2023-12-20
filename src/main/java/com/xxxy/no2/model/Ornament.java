package com.xxxy.no2.model;

import java.io.Serializable;

public class Ornament implements Serializable {
    private int ornament_id;
    private String ornament_name;
    private String ornament_image;
    private Users users;

    public Ornament() {
    }

    public Ornament(String ornament_name, String ornament_image, Users users) {
        this.ornament_name = ornament_name;
        this.ornament_image = ornament_image;
        this.users = users;
    }

    public Ornament(int ornament_id, String ornament_name, String ornament_image) {
        this.ornament_id = ornament_id;
        this.ornament_name = ornament_name;
        this.ornament_image = ornament_image;
    }

    public Ornament(int ornament_id, String ornament_name, String ornament_image, Users users) {
        this.ornament_id = ornament_id;
        this.ornament_name = ornament_name;
        this.ornament_image = ornament_image;
        this.users = users;
    }

    public int getOrnament_id() {
        return ornament_id;
    }

    public void setOrnament_id(int ornament_id) {
        this.ornament_id = ornament_id;
    }

    public String getOrnament_name() {
        return ornament_name;
    }

    public void setOrnament_name(String ornament_name) {
        this.ornament_name = ornament_name;
    }

    public String getOrnament_image() {
        return ornament_image;
    }

    public void setOrnament_image(String ornament_image) {
        this.ornament_image = ornament_image;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
