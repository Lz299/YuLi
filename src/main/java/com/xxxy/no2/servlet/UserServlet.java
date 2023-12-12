package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.User;
import com.xxxy.no2.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
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

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserService();

        User user=userService.Login(username,password);
        if(user!=null){
            Gson gson=new Gson();
            String json =gson.toJson(user);
            System.out.println(json);
            out.write(json);
            out.close();
        }

    }
}
