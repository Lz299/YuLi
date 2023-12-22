package com.xxxy.no2.dao;

import com.xxxy.no2.model.Hat;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.utils.C3P0Utils;
import com.xxxy.no2.utils.CommonUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HatDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    //增加
    public int insert(Hat hat){
        int insert  = 0;
        try {
            insert = queryRunner.update(
                    "insert into hats(hats_id,hats_name,hats_image) " +
                            "values (?,?,?)",
                    hat.getUsers().getUsers_id(),
                    hat.getHats_name(),
                    hat.getHats_image());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    //查询
    public List<Hat> findAll() {
        List<Hat> list = new ArrayList<>();
        try {
            String sql = "select * from hats ,users  where hats.users_id= users.users_id";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler());
            for (int i = 0; i < list1.size(); i++) {
                Hat hat = CommonUtils.tobean(list1.get(i), Hat.class);
                Users users = CommonUtils.tobean(list1.get(i), Users.class);
                hat.setUsers(users);
                list.add(hat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //修改
    public int update(Hat hat) {
        int update = 0;
        try {
            update = queryRunner.update(
                    "update hats set hats_name = ?,hats_image = ? where hats_id = ?",
                    hat.getHats_name(),
                    hat.getHats_image(),
                    hat.getHats_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //删除
    public int delById(int id){
        int delete = 0;
        try {
            delete = queryRunner.update("delete from hats where hats_id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }

    public List<Hat> findByUsersId(int users_id){
        List<Hat> list = new ArrayList<>();
        try {
            String sql = "select * from hats ,users  where hats.users_id= users.users_id and hats.users_id=?";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler(), users_id);
            for (int i = 0; i < list1.size(); i++) {
                Hat hat = CommonUtils.tobean(list1.get(i), Hat.class);
                Users users = CommonUtils.tobean(list1.get(i), Users.class);
                hat.setUsers(users);
                list.add(hat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}




