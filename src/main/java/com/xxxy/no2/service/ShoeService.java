package com.xxxy.no2.service;

import com.xxxy.no2.dao.PantDao;
import com.xxxy.no2.dao.ShoeDao;
import com.xxxy.no2.model.Pant;
import com.xxxy.no2.model.Shoe;

import java.util.List;

public class ShoeService {
    ShoeDao dao=new ShoeDao();
    public int insert(Shoe shoe) {
        return dao.insert(shoe);
    }

    public List<Shoe> find(){
        return dao.findAll();
    }

    public int update(Shoe shoe){
        return dao.update(shoe);
    }

    public int delById(int id){
        return dao.delById(id);
    }

}
