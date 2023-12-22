package com.xxxy.no2.dao;

import com.xxxy.no2.model.Pant;
import com.xxxy.no2.model.Pant;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.utils.C3P0Utils;
import com.xxxy.no2.utils.CommonUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PantDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    //增加
    public int insert(Pant pant){
        int insert  = 0;
        try {
            insert = queryRunner.update(
                    "insert into pants(users_id,pants_name,pants_image) " +
                            "values (?,?,?)",
                    pant.getUsers().getUsers_id(),
                    pant.getPants_name(),
                    pant.getPants_image());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    //查询
    public List<Pant> findAll() {
        List<Pant> list = new ArrayList<>();
        try {
            String sql = "select * from tops ,users  where tops.users_id= users.users_id";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler());
            for (int i = 0; i < list1.size(); i++) {
                Pant pant = CommonUtils.tobean(list1.get(i), Pant.class);
                Users users = CommonUtils.tobean(list1.get(i), Users.class);
                pant.setUsers(users);
                list.add(pant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //修改
    public int update(Pant pant) {
        int update = 0;
        try {
            update = queryRunner.update(
                    "update pants set pants_name = ?,pants_image = ? where pants_id = ?",
                    pant.getPants_name(),
                    pant.getPants_image(),
                    pant.getPants_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //删除
    public int delById(int id){
        int delete = 0;
        try {
            delete = queryRunner.update("delete from pants where pants_id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }

    public List<Pant> findByUsersId(int users_id){
        List<Pant> list = new ArrayList<>();
        try {
            String sql = "select * from pants,users  where pants.users_id= users.users_id and pants.users_id=?";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler(), users_id);
            for (int i = 0; i < list1.size(); i++) {
                Pant hat = CommonUtils.tobean(list1.get(i), Pant.class);
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
