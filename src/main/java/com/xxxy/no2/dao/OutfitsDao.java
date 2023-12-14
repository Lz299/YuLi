package com.xxxy.no2.dao;

import com.xxxy.no2.model.*;
import com.xxxy.no2.utils.C3P0Utils;
import com.xxxy.no2.utils.CommonUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutfitsDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    //增加
    public int insert(Outfit outfit){
        int insert  = 0;
        try {
            insert = queryRunner.update(
                    "insert into outfits(shoes_id," +
                            "hats_id," +
                            "ornament_id," +
                            "users_id," +
                            "tops_id," +
                            "pants_id," +
                            "outfits_name," +
                            "outfits_image) " +
                            "values (?,?,?,?,?,?,?,?)",
                    outfit.getShoes().getShoes_id(),
                    outfit.getHats().getHats_id(),
                    outfit.getOrnament().getOrnament_id(),
                    outfit.getUsers().getUsers_id(),
                    outfit.getTops().getTops_id(),
                    outfit.getPants().getPants_id(),
                    outfit.getOutfits_name(),
                    outfit.getOutfits_image());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    //查询
    public List<Outfit> findAll() {
        List<Outfit> list = new ArrayList<>();
        try {
            String sql = "select * from outfits o join users u on o.users_id = u.users_id " +
                    "join tops t on o.tops_id = t.tops_id " +
                    "join pants p on o.pants_id = p.pants_id " +
                    "join shoes s on o.shoes_id = s.shoes_id " +
                    "join hats h on o.hats_id = h.hats_id " +
                    "join ornament orn on o.ornament_id = orn.ornament_id";
            List<Map<String, Object>> list1 = queryRunner.query(sql, new MapListHandler());
            for (int i = 0; i < list1.size(); i++) {
                Outfit outfit = CommonUtils.tobean(list1.get(i), Outfit.class);
                User user = CommonUtils.tobean(list1.get(i), User.class);
                Top top = CommonUtils.tobean(list1.get(i), Top.class);
                Pant pant = CommonUtils.tobean(list1.get(i), Pant.class);
                Shoe shoe = CommonUtils.tobean(list1.get(i), Shoe.class);
                Hat hat = CommonUtils.tobean(list1.get(i), Hat.class);
                Ornament ornament = CommonUtils.tobean(list1.get(i), Ornament.class);
                outfit.setUsers(user);
                outfit.setTops(top);
                outfit.setPants(pant);
                outfit.setShoes(shoe);
                outfit.setHats(hat);
                outfit.setOrnament(ornament);
                list.add(outfit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //修改
    public int update(Outfit outfit) {
        int update = 0;
        try {
            update = queryRunner.update(
                    "update outfits set shoes_id = ?" +
                            ",hats_id = ?," +
                            "ornament_id = ?," +
                            "tops_id = ?," +
                            "pants_id = ? ," +
                            "outfits_name = ?," +
                            "outfits_image = ? where outfits_id = ?",
                    outfit.getShoes().getShoes_id(),
                    outfit.getHats().getHats_id(),
                    outfit.getOrnament().getOrnament_id(),
                    outfit.getTops().getTops_id(),
                    outfit.getPants().getPants_id(),
                    outfit.getOutfits_name(),
                    outfit.getOutfits_image(),
                    outfit.getOutfits_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //删除
    public int delById(int id){
        int delete = 0;
        try {
            delete = queryRunner.update("delete from outfits where outfits_id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }

}
