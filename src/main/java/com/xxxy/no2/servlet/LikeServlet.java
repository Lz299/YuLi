package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Like;
import com.xxxy.no2.model.Posts;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.service.LikeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LikeServlet", value = "/LikeServlet")
public class LikeServlet extends HttpServlet {
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

        LikeService service=new LikeService();

        String users_id = request.getParameter("users_id");
        String posts_id = request.getParameter("posts_id");

        int flag= Integer.parseInt(request.getParameter("flag"));


        //add//添加
        if (users_id!=null&&posts_id!=null) {
            Like like = new Like();
            Users users = new Users();
            users.setUsers_id(Integer.parseInt(users_id));
            Posts posts = new Posts();
            posts.setPosts_id(Integer.parseInt(posts_id));
            like.setUser(users);
            like.setPost(posts);
            int a = service.addLike(like);
            Gson gson = new Gson();
            String json = gson.toJson(a);
            System.out.println(json);
            out.write(json);
            out.close();
        }else if (flag==1){
            //查行数
            int a = service.findAll().size();
            Gson gson = new Gson();
            String json = gson.toJson(a);
            System.out.println(json);
            out.write(json);
            out.close();
        }else if (users_id==null&posts_id==null&flag==0){
            //findall
            List<Like> list=service.findAll();  //查
            if(list!=null) {
                Gson gson = new Gson();
                String json = gson.toJson(list);
                System.out.println(json);
                out.write(json);
                out.close();
        }


        }


    }
}
