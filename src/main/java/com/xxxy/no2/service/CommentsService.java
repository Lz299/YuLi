package com.xxxy.no2.service;

import com.xxxy.no2.dao.CommentsDao;
import com.xxxy.no2.model.Comments;

import java.util.ArrayList;
import java.util.List;

public class CommentsService {
    CommentsDao dao=new CommentsDao();
    //增
    public int addComments(Comments comments){
        int a=dao.addComments(comments);
        return a;
    }

    //删
    public int deleteComments(int id){
        int a=dao.delete(id);
        return a;
    }

    //查所有
    public List<Comments> getAllComments(){
        List<Comments> list=dao.findAll();
        return list;
    }

}
