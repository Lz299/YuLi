package com.xxxy.no2.service;

import com.xxxy.no2.dao.UserDao;
import com.xxxy.no2.model.Users;

public class UserService {

    UserDao dao=new UserDao();

    public Users Login(String username, String password) {
        return dao.Login(username, password);
    }


    public int add(Users users) {
        return dao.add(users);
    }

    public Users findUserByPhone(String phone){
        return dao.findUserByPhone(phone);
    }

    public int updateUser_id(Users users){
        return dao.updateUser_img(users);
    }
}
