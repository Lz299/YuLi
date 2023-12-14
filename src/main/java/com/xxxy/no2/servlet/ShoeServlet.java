package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Pant;
import com.xxxy.no2.model.Shoe;
import com.xxxy.no2.model.User;
import com.xxxy.no2.service.PantService;
import com.xxxy.no2.service.ShoeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShoeServlet", value = "/ShoeServlet")
public class ShoeServlet extends HttpServlet {
    ShoeService shoeService = new ShoeService();

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
        String shoes_name = request.getParameter("shoes_name");
        String shoes_image = request.getParameter("shoes_image");
        //修改获取字段
        String shoes_id = request.getParameter("shoes_id");
        String update_shoes_name = request.getParameter("update_shoes_name");
        String update_shoes_image = request.getParameter("update_shoes_image");



        //查询
        if (users_id == null && shoes_name == null && shoes_image == null &&shoes_id == null){
            all(response);
        }

        //添加
        if (users_id != null && shoes_name != null && shoes_image != null){
            User user = new User();
            user.setUsers_id(Integer.parseInt(users_id));
            Shoe shoe = new Shoe(shoes_name,shoes_image,user);
            shoeService.insert(shoe);
            all(response);
        }

        //修改
        if (shoes_id != null && update_shoes_name != null && update_shoes_image != null){
            Shoe shoe = new Shoe(Integer.parseInt(shoes_id),update_shoes_name,update_shoes_image);
            shoeService.update(shoe);
            all(response);
        }

        //删除
        if (shoes_id != null && update_shoes_name == null && update_shoes_image == null &&users_id == null){
            shoeService.delById(Integer.parseInt(shoes_id));
            all(response);
        }
    }
    public void all( HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        List<Shoe> all = shoeService.find();
        String json = gson.toJson(all);
        System.out.println(json);
        out.write(json);
        out.close();
    }
}
