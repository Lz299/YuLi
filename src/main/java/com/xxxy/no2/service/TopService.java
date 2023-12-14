package com.xxxy.no2.service;

import com.xxxy.no2.dao.TopDao;
import com.xxxy.no2.model.Top;

import java.util.List;

public class TopService {
    TopDao topDao = new TopDao();

    public int insert(Top top) {
        return topDao.insert(top);
    }

    public List<Top> findAllTop(){
        return topDao.findAllTop();
    }

    public int updateTop(Top top){
        return topDao.updateTop(top);
    }

    public int delTopById(int id){
        return topDao.delTopById(id);
    }


}
