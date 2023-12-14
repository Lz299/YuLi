package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Hat;
import com.xxxy.no2.model.Shoe;
import com.xxxy.no2.model.User;
import com.xxxy.no2.service.HatService;
import com.xxxy.no2.service.ShoeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HatServlet", value = "/HatServlet")
public class HatServlet extends HttpServlet {
    HatService hatService = new HatService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //添加
        String users_id =  request.getParameter("users_id");
        String hats_name = request.getParameter("hats_name");
        String hats_image = request.getParameter("hats_image");
        //修改获取字段
        String hats_id = request.getParameter("hats_id");
        String update_hats_name = request.getParameter("update_hats_name");
        String update_hats_image = request.getParameter("update_hats_image");

        //查询
        if (users_id == null && hats_name == null && hats_image == null &&hats_id == null){
            all(response);
        }

        //添加
        if (users_id != null && hats_name != null && hats_image != null){
            User user = new User();
            user.setUsers_id(Integer.parseInt(users_id));
            Hat hat = new Hat(hats_name,hats_image,user);
            hatService.insert(hat);
            all(response);
        }

        //修改
        if (hats_id != null && update_hats_name != null && update_hats_image != null){
            Hat hat = new Hat(Integer.parseInt(hats_id),update_hats_name,update_hats_image);
            hatService.update(hat);
            all(response);
        }

        //删除
        if (hats_id != null && update_hats_name == null && update_hats_image == null &&users_id == null){
            hatService.delById(Integer.parseInt(hats_id));
            all(response);
        }
    }
    public void all( HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        List<Hat> all = hatService.find();
        String json = gson.toJson(all);
        System.out.println(json);
        out.write(json);
        out.close();
    }
}
