package com.xxxy.no2.service;

import com.xxxy.no2.dao.HatDao;
import com.xxxy.no2.dao.OutfitsDao;
import com.xxxy.no2.model.Hat;
import com.xxxy.no2.model.Outfit;

import java.util.List;

public class OutfittService {
    OutfitsDao dao=new OutfitsDao();
    public int insert(Outfit outfit) {
        return dao.insert(outfit);
    }

    public List<Outfit> find(){
        return dao.findAll();
    }

    public int update(Outfit outfit){
        return dao.update(outfit);
    }

    public int delById(int id){
        return dao.delById(id);
    }

}
