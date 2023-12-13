package com.xxxy.no2.dao;

import com.xxxy.no2.model.User;
import com.xxxy.no2.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());

    //登录
    public User Login(String username, String password){
        User user=null;
        try {
            user=queryRunner.query("select *from users where username=? and password=?",new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int add(User user){
        int add=0;
        try {
            add= queryRunner.update("insert into users (username,password,phone) values(?,?,?)",user.getUsername(),user.getPassword(),user.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return add;
    }


    public User findUserByPhone(String phone){
        User user=null;
        try {
            user=queryRunner.query("select *from users where phone=?",new BeanHandler<User>(User.class),phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

}
