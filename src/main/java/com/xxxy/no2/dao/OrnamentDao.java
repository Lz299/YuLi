package com.xxxy.no2.dao;

import com.xxxy.no2.model.Ornament;
import com.xxxy.no2.model.Ornament;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.utils.C3P0Utils;
import com.xxxy.no2.utils.CommonUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrnamentDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    //增加
    public int insert(Ornament ornament){
        int insert  = 0;
        try {
            insert = queryRunner.update(
                    "insert into ornament(ornament_id,ornament_name,ornament_image) " +
                            "values (?,?,?)",
                    ornament.getUsers().getUsers_id(),
                    ornament.getOrnament_name(),
                    ornament.getOrnament_image());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    //查询
    public List<Ornament> findAll() {
        List<Ornament> list = new ArrayList<>();
        try {
            String sql = "select * from ornament ,users  where ornament.users_id= users.users_id";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler());
            for (int i = 0; i < list1.size(); i++) {
                Ornament ornament = CommonUtils.tobean(list1.get(i), Ornament.class);
                Users users = CommonUtils.tobean(list1.get(i), Users.class);
                ornament.setUsers(users);
                list.add(ornament);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //修改
    public int update(Ornament ornament) {
        int update = 0;
        try {
            update = queryRunner.update(
                    "update ornament set ornament_name = ?,ornament_image = ? where ornament_id = ?",
                    ornament.getOrnament_name(),
                    ornament.getOrnament_image(),
                    ornament.getOrnament_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //删除
    public int delById(int id){
        int delete = 0;
        try {
            delete = queryRunner.update("delete from ornament where ornament_id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }

    public List<Ornament> findByUsersId(int users_id){
        List<Ornament> list = new ArrayList<>();
        try {
            String sql = "select * from pants,users  where pants.users_id= users.users_id and pants.users_id=?";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler(), users_id);
            for (int i = 0; i < list1.size(); i++) {
                Ornament hat = CommonUtils.tobean(list1.get(i), Ornament.class);
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
