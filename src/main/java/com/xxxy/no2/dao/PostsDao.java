package com.xxxy.no2.dao;

import com.xxxy.no2.model.Posts;
import com.xxxy.no2.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostsDao {
    QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());

    public List<Posts> findAll(){
        List<Posts> list=new ArrayList<>();

        try {
            list= queryRunner.query("SELECT * FROM posts", new BeanListHandler<>(Posts.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int  addPost(Posts posts){
        int a=0;
        try {
            a=queryRunner.update("INSERT INTO posts(users_id,posts_title,posts_content) VALUES(?,?,?)",posts.getUsers_id().getId(),posts.getPosts_title(),posts.getPosts_content());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public int delPost(int id){
        int a=0;
        try {
            a=queryRunner.update("DELETE FROM posts WHERE posts_id = ?",id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public int updatePost(Posts posts){
        int a=0;
        try {
            a=queryRunner.update("UPDATE posts SET users_id, posts_title = ?,posts_content = ? WHERE posts_id = ?",posts.getUsers_id().getId(),posts.getPosts_title(),posts.getPosts_content(),posts.getPosts_id());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public List<Posts> findPostById(int userid){
        List<Posts> list=new ArrayList<>();
        try {
            list= queryRunner.query("SELECT * FROM posts WHERE users_id = ?", new BeanListHandler<>(Posts.class),userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
