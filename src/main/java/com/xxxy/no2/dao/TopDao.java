package com.xxxy.no2.dao;
import com.xxxy.no2.model.Top;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.utils.C3P0Utils;
import com.xxxy.no2.utils.CommonUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    //增加
    public int insert(Top top){
        int insert  = 0;
        try {
            insert = queryRunner.update(
                    "insert into tops(users_id,tops_name,tops_image) " +
                            "values (?,?,?)",
                    top.getUsers().getUsers_id(),
                    top.getTops_name(),
                    top.getTops_image());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    //查询
    public List<Top> findAllTop() {
        List<Top> list = new ArrayList<>();
        try {
            String sql = "select * from tops ,users  where tops.users_id= users.users_id";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler());
            for (int i = 0; i < list1.size(); i++) {
                Top top = CommonUtils.tobean(list1.get(i), Top.class);
                Users users = CommonUtils.tobean(list1.get(i), Users.class);
                top.setUsers(users);
                list.add(top);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //修改
    public int updateTop(Top top) {
        int update = 0;
        try {
            update = queryRunner.update(
                    "update tops set tops_name = ?,tops_image = ? where tops_id = ?",
                    top.getTops_name(),
                    top.getTops_image(),
                    top.getTops_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //删除
    public int delTopById(int id){
        int delete = 0;
        try {
            delete = queryRunner.update("delete from tops where tops_id = ?",id);
            System.out.println(delete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }


}
