package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Pant;
import com.xxxy.no2.model.Shoe;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.service.PantService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PantServlet", value = "/PantServlet")
public class PantServlet extends HttpServlet {
    PantService pantService = new PantService();

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
        String pants_name = request.getParameter("pants_name");
        String pants_image = request.getParameter("pants_image");
        //修改获取字段
        String pants_id = request.getParameter("pants_id");
        String update_pants_name = request.getParameter("update_pants_name");
        String update_pants_image = request.getParameter("update_pants_image");

        if (users_id!=null&&pants_name==null&&pants_image==null){
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            List<Pant> allTop = pantService.findByid(Integer.parseInt(users_id));
            String json = gson.toJson(allTop);
            System.out.println(json);
            out.write(json);
            out.close();
        }

        //查询
        if (users_id == null && pants_name == null && pants_image == null &&pants_id == null){
            all(response);
        }

        //添加
        if (users_id != null && pants_name != null && pants_image != null){
            Users users = new Users();
            users.setUsers_id(Integer.parseInt(users_id));
            Pant pant = new Pant(pants_name,pants_image, users);
            pantService.insert(pant);
            all(response);
        }

        //修改
        if (pants_id != null && update_pants_name != null && update_pants_image != null){
            Pant pant = new Pant(Integer.parseInt(pants_id),update_pants_name,update_pants_image);
            pantService.update(pant);
            all(response);
        }

        //删除
        if (pants_id != null && update_pants_name == null && update_pants_image == null &&users_id == null){
            pantService.delById(Integer.parseInt(pants_id));
            all(response);
        }
    }
    public void all( HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        List<Pant> all = pantService.find();
        String json = gson.toJson(all);
        System.out.println(json);
        out.write(json);
        out.close();
    }
}
