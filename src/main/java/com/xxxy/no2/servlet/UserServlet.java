package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    HttpSession session;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
       Sample sample=new Sample();
        session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        Random random=new Random();
        String ayzm = request.getParameter("code");
        String phone = request.getParameter("phone");

if (phone!=null&&ayzm==null) {
    int randomNumber = random.nextInt(900000) + 100000;
    sample.send(phone, String.valueOf(randomNumber));
    Gson gson = new Gson();
    String json = gson.toJson(String.valueOf(randomNumber));
    System.out.println(json);
    out.write(json);
    out.close();

}


        UserService userService = new UserService();
        if (username!=null&&password!=null){
            Users users =userService.Login(username,password);
            if(users !=null){
                Gson gson=new Gson();
                String json =gson.toJson(users);
                System.out.println(json);
                out.write(json);
                out.close();
            }

        }else if (phone!=null&&ayzm!=null){

                Users users = userService.findUserByPhone(phone);
                if (users != null) {
                    Gson gson = new Gson();
                    String json = gson.toJson(users);
                    System.out.println(json);
                    out.write(json);
                    out.close();
                }

        }else {
            out.write("参数错误");
        }


    }
}
