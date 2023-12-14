package com.xxxy.no2.service;

import com.xxxy.no2.dao.LikeDao;
import com.xxxy.no2.model.Like;

import java.util.List;

public class LikeService {
    LikeDao dao=new LikeDao();
    public List<Like> findAll(){
        return dao.findAll();
    }

    public  int addLike(Like like){
        return dao.addLike(like);
    }
    public int countLikes(int post_id){
        return dao.countLikes(post_id);
    }

}
