package com.xxxy.no2.service;

import com.xxxy.no2.dao.PantDao;
import com.xxxy.no2.dao.PostsDao;
import com.xxxy.no2.model.Pant;
import com.xxxy.no2.model.Top;


import java.util.List;

public class PantService {
    PantDao dao=new PantDao();
    public int insert(Pant top) {
        return dao.insert(top);
    }

    public List<Pant> find(){
        return dao.findAll();
    }

    public int update(Pant top){
        return dao.update(top);
    }

    public int delById(int id){
        return dao.delById(id);
    }
    public List<Pant> findByid(int id){
        return dao.findByUsersId(id);
    }


}
