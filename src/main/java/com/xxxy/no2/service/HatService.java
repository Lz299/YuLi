package com.xxxy.no2.service;

import com.xxxy.no2.dao.HatDao;
import com.xxxy.no2.dao.ShoeDao;
import com.xxxy.no2.model.Hat;
import com.xxxy.no2.model.Shoe;

import java.util.List;

public class HatService {
    HatDao dao=new HatDao();
    public int insert(Hat hat) {
        return dao.insert(hat);
    }

    public List<Hat> find(){
        return dao.findAll();
    }

    public int update(Hat hat){
        return dao.update(hat);
    }

    public int delById(int id){
        return dao.delById(id);
    }
    public List<Hat> findById(int id){
        return dao.findByUsersId(id);
    }

}
