package com.xxxy.no2.service;

import com.xxxy.no2.dao.UserDao;
import com.xxxy.no2.model.User;

public class UserService {

    UserDao dao=new UserDao();

    public User Login(String username, String password) {
        return dao.Login(username, password);
    }


    public int add(User user) {
        return dao.add(user);
    }

    public User findUserByPhone(String phone){
        return dao.findUserByPhone(phone);
    }

}
