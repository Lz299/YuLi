package com.xxxy.no2.dao;

import com.xxxy.no2.model.Like;
import com.xxxy.no2.model.Posts;
import com.xxxy.no2.model.User;
import com.xxxy.no2.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LikeDao {
    QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());

    public List<Like> findAll(){
        List<Like> list=new ArrayList<>();
        try {
            List<Map<String,Object>> list1=queryRunner.query("select * from likes",new MapListHandler());


            for(Map<String,Object> map:list1){
                Like like=new Like();
                like.setUser((User)map.get("user"));
                like.setPost((Posts)map.get("post"));
                list.add(like);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public  int addLike(Like like) {
        int a=0;
        try {
            a= queryRunner.update("insert into likes(user_id,post_id) values(?,?)",like.getUser().getId(),like.getPost().getPosts_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //统计likes数
    public int countLikes(int post_id){
        int count=0;
        try {
            count=queryRunner.query("select count(*) from likes where post_id=?",new ScalarHandler<Integer>(),post_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


}
