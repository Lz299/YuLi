package com.xxxy.no2.dao;

import com.xxxy.no2.model.Shoe;
import com.xxxy.no2.model.Shoe;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.utils.C3P0Utils;
import com.xxxy.no2.utils.CommonUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShoeDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    //增加
    public int insert(Shoe shoe){
        int insert  = 0;
        try {
            insert = queryRunner.update(
                    "insert into shoes(shoes_id,shoes_name,shoes_image) " +
                            "values (?,?,?)",
                    shoe.getUsers().getUsers_id(),
                    shoe.getShoes_name(),
                    shoe.getShoes_image());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    //查询
    public List<Shoe> findAll() {
        List<Shoe> list = new ArrayList<>();
        try {
            String sql = "select * from shoes ,users  where shoes.users_id= users.users_id";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler());
            for (int i = 0; i < list1.size(); i++) {
                Shoe shoe = CommonUtils.tobean(list1.get(i), Shoe.class);
                Users users = CommonUtils.tobean(list1.get(i), Users.class);
                shoe.setUsers(users);
                list.add(shoe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //修改
    public int update(Shoe shoe) {
        int update = 0;
        try {
            update = queryRunner.update(
                    "update shoes set shoes_name = ?,shoes_image = ? where shoes_id = ?",
                    shoe.getShoes_name(),
                    shoe.getShoes_image(),
                    shoe.getShoes_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //删除
    public int delById(int id){
        int delete = 0;
        try {
            delete = queryRunner.update("delete from shoes where shoes_id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }
    public List<Shoe> findByUsersId(int users_id){
        List<Shoe> list = new ArrayList<>();
        try {
            String sql = "select * from shoes ,users  where shoes.users_id= users.users_id and shoes.users_id=?";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler(), users_id);
            for (int i = 0; i < list1.size(); i++) {
                Shoe hat = CommonUtils.tobean(list1.get(i), Shoe.class);
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
