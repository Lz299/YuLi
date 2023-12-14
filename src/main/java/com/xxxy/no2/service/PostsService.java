package com.xxxy.no2.service;

import com.xxxy.no2.dao.PostsDao;
import com.xxxy.no2.model.Posts;

import java.util.List;

public class PostsService {
    PostsDao dao=new PostsDao();
    public int delete(int id){
        return dao.delPost(id);
    }
    public List<Posts>  getAll(){
        return  dao.findAll();
    }
    public List<Posts> findById(int id){
        return dao.findPostById(id);
    }
    public int add(Posts posts){
        return dao.addPost(posts);
    }
    public int update(Posts posts){
        return dao.updatePost(posts);
    }
}
