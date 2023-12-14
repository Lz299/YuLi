package com.xxxy.no2.model;

import java.io.Serializable;

public class Top implements Serializable {
    private int tops_id;
    private User users_id;
    private String tops_name;
    private String tops_image;

    public Top() {
    }

    public Top(User users_id, String tops_name, String tops_image) {
        this.users_id = users_id;
        this.tops_name = tops_name;
        this.tops_image = tops_image;
    }


    public Top(int tops_id, String tops_name, String tops_image) {
        this.tops_id = tops_id;
        this.tops_name = tops_name;
        this.tops_image = tops_image;
    }

    public Top(int tops_id, User users_id, String tops_name, String tops_image) {
        this.tops_id = tops_id;
        this.users_id = users_id;
        this.tops_name = tops_name;
        this.tops_image = tops_image;
    }



    public int getTops_id() {
        return tops_id;
    }

    public void setTops_id(int tops_id) {
        this.tops_id = tops_id;
    }

    public User getUsers_id() {
        return users_id;
    }

    public void setUsers_id(User users_id) {
        this.users_id = users_id;
    }

    public String getTops_name() {
        return tops_name;
    }

    public void setTops_name(String tops_name) {
        this.tops_name = tops_name;
    }

    public String getTops_image() {
        return tops_image;
    }

    public void setTops_image(String tops_image) {
        this.tops_image = tops_image;
    }

    @Override
    public String toString() {
        return "Top{" +
                "tops_id=" + tops_id +
                ", users_id=" + users_id +
                ", tops_name='" + tops_name + '\'' +
                ", tops_image='" + tops_image + '\'' +
                '}';
    }
}
