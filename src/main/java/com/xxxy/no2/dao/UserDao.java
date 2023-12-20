package com.xxxy.no2.dao;

import com.xxxy.no2.model.Users;
import com.xxxy.no2.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());

    //登录
    public Users Login(String username, String password){
        Users users =new Users();
        try {
            users =queryRunner.query("select *from users where username=? and password=?",new BeanHandler<Users>(Users.class),username,password);
            System.out.println(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public int add(Users users){
        int add=0;
        try {
            add= queryRunner.update("insert into users (username,password,phone,users_img) values(?,?,?)", users.getUsername(), users.getPassword(), users.getPhone(),"img.png");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return add;
    }


    public Users findUserByPhone(String phone){
        Users users =new Users();
        try {
            users =queryRunner.query("select *from users where phone=?",new BeanHandler<Users>(Users.class),phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    public int  updateUser_img(Users users){
        int update=0;
        try {
            update= queryRunner.update("update users set users_img=? where users_id=?",users.getUsers_img(),users.getUsers_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

}
