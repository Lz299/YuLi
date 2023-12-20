package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Ornament;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.service.OrnamentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OrnamentServlet", value = "/OrnamentServlet")
public class OrnamentServlet extends HttpServlet {
    OrnamentService ornamentService = new OrnamentService();

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
        String ornament_name = request.getParameter("ornament_name");
        String ornament_image = request.getParameter("ornament_image");
        //修改获取字段
        String ornament_id = request.getParameter("ornament_id");
        String update_ornament_name = request.getParameter("update_ornament_name");
        String update_ornament_image = request.getParameter("update_ornament_image");



        //查询
        if (users_id == null && ornament_name == null && ornament_image == null &&ornament_id == null){
            all(response);
        }

        //添加
        if (users_id != null && ornament_name != null && ornament_image != null){
            Users users = new Users();
            users.setUsers_id(Integer.parseInt(users_id));
            Ornament ornament = new Ornament(ornament_name,ornament_image, users);
            ornamentService.insert(ornament);
            all(response);
        }

        //修改
        if (ornament_id != null && update_ornament_name != null && update_ornament_image != null){
            Ornament ornament = new Ornament(Integer.parseInt(ornament_id),update_ornament_name,update_ornament_image);
            ornamentService.update(ornament);
            all(response);
        }

        //删除
        if (ornament_id != null && update_ornament_name == null && update_ornament_image == null &&users_id == null){
            ornamentService.delById(Integer.parseInt(ornament_id));
            all(response);
        }
    }
    public void all( HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        List<Ornament> all = ornamentService.find();
        String json = gson.toJson(all);
        System.out.println(json);
        out.write(json);
        out.close();
    }
}
