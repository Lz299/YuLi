package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.*;
import com.xxxy.no2.service.HatService;
import com.xxxy.no2.service.OutfittService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OutfitServlet", value = "/OutfitServlet")
public class OutfitServlet extends HttpServlet {
    OutfittService outfittService = new OutfittService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //添加
        String tops_id = request.getParameter("tops_id");
        String pants_id = request.getParameter("pants_id");
        String shoes_id = request.getParameter("shoes_id");
        String hats_id = request.getParameter("hats_id");
        String users_id = request.getParameter("users_id");
        String ornament_id = request.getParameter("ornament_id");
        String outfits_name = request.getParameter("outfits_name");
        String outfits_image = request.getParameter("outfits_image");
        //修改获取字段
        String outfits_id = request.getParameter("outfits_id");
        String update_tops_id = request.getParameter("update_tops_id");
        String update_pants_id = request.getParameter("update_pants_id");
        String update_shoes_id = request.getParameter("update_shoes_id");
        String update_hats_id = request.getParameter("update_hats_id");
        String update_ornament_id = request.getParameter("update_ornament_id");
        String update_outfits_name = request.getParameter("update_outfits_name");
        String update_outfits_image = request.getParameter("update_outfits_image");


        //查询
        if (users_id == null && tops_id == null && pants_id == null && shoes_id == null && hats_id == null
                && ornament_id == null && outfits_name == null && outfits_image == null && outfits_id == null) {
            all(response);
        }

        //添加
        if (users_id != null && tops_id != null && pants_id != null && shoes_id != null && hats_id != null
                && ornament_id != null && outfits_name != null && outfits_image != null) {
            User user = new User();
            user.setUsers_id(Integer.parseInt(users_id));
            Top top = new Top();
            top.setTops_id(Integer.parseInt(tops_id));
            Pant pant = new Pant();
            pant.setPants_id(Integer.parseInt(pants_id));
            Shoe shoe = new Shoe();
            shoe.setShoes_id(Integer.parseInt(shoes_id));
            Hat hat = new Hat();
            hat.setHats_id(Integer.parseInt(hats_id));
            Ornament ornament = new Ornament();
            ornament.setOrnament_id(Integer.parseInt(ornament_id));
            Outfit outfit = new Outfit(outfits_name, outfits_image, user,top,pant,shoe,hat,ornament);
            outfittService.insert(outfit);
            all(response);
        }

        //修改
        if (outfits_id != null && update_outfits_name != null && update_outfits_image != null) {
            Outfit outfit = new Outfit(Integer.parseInt(outfits_id), update_outfits_name, update_outfits_image);
            outfittService.update(outfit);
            all(response);
        }

        //删除
        if (outfits_id != null && update_tops_id == null && update_pants_id == null&& update_shoes_id == null
                && update_hats_id == null&& update_ornament_id == null&& update_outfits_name == null
                && update_outfits_image == null) {
            outfittService.delById(Integer.parseInt(outfits_id));
            all(response);
        }
    }

    public void all(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        List<Outfit> all = outfittService.find();
        String json = gson.toJson(all);
        System.out.println(json);
        out.write(json);
        out.close();
    }
}
