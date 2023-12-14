package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.User;
import com.xxxy.no2.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ZhuCeServlet", value = "/ZhuCeServlet")
public class ZhuCeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        if (phone!=null&&username!=null&&password!=null){
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
           int a= userService.add(user);
           if (a!=0){
               Gson gson=new Gson();
               String json =gson.toJson(a);
               System.out.println(json);
               out.write(json);
               out.close();
           }
        }else {
            out.write("手机号、用户名和密码不能为空");
        }




    }
}
