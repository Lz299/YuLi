package com.xxxy.no2.dao;

import com.xxxy.no2.model.Comments;
import com.xxxy.no2.model.Like;
import com.xxxy.no2.model.Posts;
import com.xxxy.no2.model.User;
import com.xxxy.no2.utils.C3P0Utils;
import com.xxxy.no2.utils.CommonUtlis;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentsDao {
    QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());

    public List<Comments> findAll(){
        List<Comments> list=new ArrayList<>();
        try {
            List<Map<String,Object>> list1=queryRunner.query("select * from comments c,users u,posts p where c.users_id=u.users_id and c.posts_id=p.posts_id",new MapListHandler());

            for (Map<String, Object> map : list1) {
                Comments comments=CommonUtlis.tobean(map,Comments.class);
                Posts posts= CommonUtlis.tobean(map,Posts.class);
                User user=CommonUtlis.tobean(map,User.class);
                comments.setUsers(user);
                comments.setPosts(posts);
                list.add(comments);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public  int addComments(Comments comments) {
        int a=0;
        try {
            a= queryRunner.update("insert into comments(users_id,posts_id,comments_content) values(?,?,?)",comments.getUsers().getUsers_id(),comments.getPosts().getPosts_id(),comments.getComments_content());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //删除回复
    public int delete(int comments_id){
        int a=0;
        try {
            a= queryRunner.update("delete from comments where comments_id=?",comments_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }





}
