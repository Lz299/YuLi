package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Posts;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.service.PostsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PostsServlet", value = "/PostsServlet")
public class PostsServlet extends HttpServlet {
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

        //增
        String users_id = request.getParameter("users_id");
        String posts_title = request.getParameter("posts_title");
        String posts_content = request.getParameter("posts_content");

        //删
        String posts_id = request.getParameter("posts_id");

        //根据id查
        String find_posts_id = request.getParameter("find_posts_id");
        //改
        String update_posts_id = request.getParameter("update_posts_id");
        String update_users_id = request.getParameter("update_users_id");
        String update_posts_title = request.getParameter("update_posts_title");
        String update_posts_content = request.getParameter("update_posts_content");

        Posts posts=new Posts();
        PostsService service=new PostsService();

        if(users_id!=null&&posts_title!=null&&posts_content!=null){
            Users users =new Users();
            users.setUsers_id(Integer.parseInt(users_id));
            posts.setUsers(users);
            posts.setPosts_title(posts_title);
            posts.setPosts_content(posts_content);
           int a= service.add(posts);
            if (a!=0){
                Gson gson=new Gson();
                String json =gson.toJson(a);
                System.out.println(json);
                out.write(json);
                out.close();
            }
        }else if (posts_id!=null){
          int b=  service.delete(Integer.parseInt(posts_id));
            if (b!=0){
                Gson gson=new Gson();
                String json =gson.toJson(b);
                System.out.println(json);
                out.write(json);
                out.close();
            }
        }else if (update_posts_id!=null&update_users_id!=null&update_posts_title!=null&update_posts_content!=null){
            Users users =new Users();
            users.setUsers_id(Integer.parseInt(update_users_id));
            posts.setUsers(users);
            posts.setPosts_title(update_posts_title);
            posts.setPosts_content(update_posts_content);
            int c= service.update(posts);
            if (c!=0){
                Gson gson=new Gson();
                String json =gson.toJson(c);
                System.out.println(json);
                out.write(json);
                out.close();
            }
        }else if (find_posts_id!=null){
            List<Posts> list1=service.findById(Integer.parseInt(find_posts_id));
            Gson gson=new Gson();
            String json =gson.toJson(list1);
            System.out.println(json);
            out.write(json);
            out.close();

        }else if(users_id==null&&posts_title==null&&posts_content==null&posts_id==null&find_posts_id==null&update_users_id==null&update_posts_title==null&update_posts_content==null){
            List<Posts> list=service.getAll();   //查
            if(list!=null){
                Gson gson=new Gson();
                String json =gson.toJson(list);
                System.out.println(json);
                out.write(json);
                out.close();
            }
        }else {
            out.write("0");
        }

    }
}
