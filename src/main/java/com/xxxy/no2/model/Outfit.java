package com.xxxy.no2.model;

import java.io.Serializable;

public class Outfit  implements Serializable {
    private int outfits_id;
    private String outfits_name;
    private String outfits_image;
    private User users;
    private Top tops;
    private Pant pants;
    private Shoe shoes;
    private Hat hats;
    private Ornament ornament;

    public Outfit() {
    }

    public Outfit(int outfits_id, String outfits_name, String outfits_image) {
        this.outfits_id = outfits_id;
        this.outfits_name = outfits_name;
        this.outfits_image = outfits_image;
    }

    public Outfit(String outfits_name, String outfits_image, User users, Top tops, Pant pants, Shoe shoes, Hat hats, Ornament ornament) {
        this.outfits_name = outfits_name;
        this.outfits_image = outfits_image;
        this.users = users;
        this.tops = tops;
        this.pants = pants;
        this.shoes = shoes;
        this.hats = hats;
        this.ornament = ornament;
    }

    public Outfit(int outfits_id, String outfits_name, String outfits_image, Top tops, Pant pants, Shoe shoes, Hat hats, Ornament ornament) {
        this.outfits_id = outfits_id;
        this.outfits_name = outfits_name;
        this.outfits_image = outfits_image;
        this.tops = tops;
        this.pants = pants;
        this.shoes = shoes;
        this.hats = hats;
        this.ornament = ornament;
    }

    public Outfit(int outfits_id, String outfits_name, String outfits_image, User users, Top tops, Pant pants, Shoe shoes, Hat hats, Ornament ornament) {
        this.outfits_id = outfits_id;
        this.outfits_name = outfits_name;
        this.outfits_image = outfits_image;
        this.users = users;
        this.tops = tops;
        this.pants = pants;
        this.shoes = shoes;
        this.hats = hats;
        this.ornament = ornament;
    }

    public int getOutfits_id() {
        return outfits_id;
    }

    public void setOutfits_id(int outfits_id) {
        this.outfits_id = outfits_id;
    }

    public String getOutfits_name() {
        return outfits_name;
    }

    public void setOutfits_name(String outfits_name) {
        this.outfits_name = outfits_name;
    }

    public String getOutfits_image() {
        return outfits_image;
    }

    public void setOutfits_image(String outfits_image) {
        this.outfits_image = outfits_image;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Top getTops() {
        return tops;
    }

    public void setTops(Top tops) {
        this.tops = tops;
    }

    public Pant getPants() {
        return pants;
    }

    public void setPants(Pant pants) {
        this.pants = pants;
    }

    public Shoe getShoes() {
        return shoes;
    }

    public void setShoes(Shoe shoes) {
        this.shoes = shoes;
    }

    public Hat getHats() {
        return hats;
    }

    public void setHats(Hat hats) {
        this.hats = hats;
    }

    public Ornament getOrnament() {
        return ornament;
    }

    public void setOrnament(Ornament ornament) {
        this.ornament = ornament;
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "outfits_id=" + outfits_id +
                ", outfits_name='" + outfits_name + '\'' +
                ", outfits_image='" + outfits_image + '\'' +
                ", users=" + users +
                ", tops=" + tops +
                ", pants=" + pants +
                ", shoes=" + shoes +
                ", hats=" + hats +
                ", ornament=" + ornament +
                '}';
    }
}
