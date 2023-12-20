
package com.xxxy.no2.dao;

import com.xxxy.no2.model.Posts;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.utils.C3P0Utils;
import com.xxxy.no2.utils.CommonUtlis;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostsDao {
    QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());

    public List<Posts> findAll(){
        List<Posts> list=new ArrayList<>();

        try {
           List<Map<String, Object>> list1= queryRunner.query("SELECT * FROM posts,users where posts.users_id=users.users_id", new MapListHandler());

            for (int i = 0; i <list1.size() ; i++) {
                Posts posts= CommonUtlis.tobean(list1.get(i),Posts.class);
                Users users =CommonUtlis.tobean(list1.get(i), Users.class);
                posts.setUsers(users);
                list.add(posts);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int  addPost(Posts posts){
        int a=0;
        try {
            a=queryRunner.update("INSERT INTO posts(users_id,posts_title,posts_content) VALUES(?,?,?)",posts.getUsers().getUsers_id(),posts.getPosts_title(),posts.getPosts_content());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public int delPost(int id){
        int a=0;
        try {
            a=queryRunner.update("DELETE FROM likes WHERE posts_id = ?",id);
            a=queryRunner.update("DELETE FROM posts WHERE posts_id = ?",id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public int updatePost(Posts posts){
        int a=0;
        try {
            a=queryRunner.update("UPDATE posts SET  posts_title = ?,posts_content = ? WHERE posts_id = ?",posts.getPosts_title(),posts.getPosts_content(),posts.getPosts_id());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public List<Posts> findPostById(int userid) {
        List<Posts> list = new ArrayList<>();
        try {
            List<Map<String, Object>> list1 = queryRunner.query("SELECT * FROM posts,users where posts.users_id=users.users_id WHERE users_id = ?", new MapListHandler(), userid);
            for (int i = 0; i < list1.size(); i++) {
                Posts posts = CommonUtlis.tobean(list1.get(i), Posts.class);
                Users users = CommonUtlis.tobean(list1.get(i), Users.class);
                posts.setUsers(users);
                list.add(posts);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }






}
