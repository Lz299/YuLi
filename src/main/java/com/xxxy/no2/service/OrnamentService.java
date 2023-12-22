package com.xxxy.no2.service;

import com.xxxy.no2.dao.HatDao;
import com.xxxy.no2.dao.OrnamentDao;
import com.xxxy.no2.model.Hat;
import com.xxxy.no2.model.Ornament;

import java.util.List;

public class OrnamentService {
    OrnamentDao dao=new OrnamentDao();
    public int insert(Ornament ornament) {
        return dao.insert(ornament);
    }

    public List<Ornament> find(){
        return dao.findAll();
    }

    public int update(Ornament ornament){
        return dao.update(ornament);
    }

    public int delById(int id){
        return dao.delById(id);
    }
    public List<Ornament> findById(int id){
        return dao.findByUsersId(id);
    }

}
