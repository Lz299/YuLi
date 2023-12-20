package com.xxxy.no2;

import com.google.gson.Gson;

public class Test {
    public static void main(String[] args) {
        String s="\"1232313\"";
        System.out.println(s);
        String flag=new Gson().fromJson(s,String.class);
        System.out.println(flag);
    }
}
