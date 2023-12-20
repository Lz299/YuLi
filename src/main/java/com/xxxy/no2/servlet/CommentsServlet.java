package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Comments;
import com.xxxy.no2.model.Posts;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.service.CommentsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CommentsServlet", value = "/CommentsServlet")
public class CommentsServlet extends HttpServlet {
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

        CommentsService service=new CommentsService();
        String users_id = request.getParameter("users_id");
        String posts_id = request.getParameter("posts_id");
        String comments_conntent = request.getParameter("comments_conntent");

        String comments_id = request.getParameter("comments_id");
        //增
        if (users_id != null && posts_id != null && comments_conntent != null) {
            Comments comments = new Comments();
            Users users = new Users();
            Posts posts = new Posts();
            users.setUsers_id(Integer.parseInt(users_id));
            posts.setPosts_id(Integer.parseInt(posts_id));
            comments.setUsers(users);
            comments.setPosts(posts);
            comments.setComments_content(comments_conntent);
            int a=service.addComments(comments);
            Gson gson = new Gson();
            String json = gson.toJson(a);
            System.out.println(json);
            out.write(json);
            out.close();
        }else if (comments_id!=null){
            //删
            int a= service.deleteComments(Integer.parseInt(comments_id));
            Gson gson = new Gson();
            String json = gson.toJson(a);
            System.out.println(json);
            out.write(json);
            out.close();
        }else if (users_id == null && posts_id == null &&  comments_conntent == null && comments_id ==null){
            //查所有
            List<Comments> list=service.getAllComments();
            Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
            out.write(json);
            out.close();

        }








    }
}
