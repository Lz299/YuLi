package com.xxxy.no2.servlet;

import com.google.gson.Gson;
import com.xxxy.no2.model.Top;
import com.xxxy.no2.model.Users;
import com.xxxy.no2.service.TopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TopServlet", value = "/TopServlet")
public class TopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        TopService topService = new TopService();
        //添加
        String users_id =  request.getParameter("users_id");
        String tops_name =  request.getParameter("tops_name");
        String tops_image =  request.getParameter("tops_image");
        //修改获取字段
        String tops_id =  request.getParameter("tops_id");
        System.out.println(tops_id);
        String update_tops_name =  request.getParameter("update_tops_name");
        String updata_tops_image =  request.getParameter("updata_tops_image");



        //查询
        if (users_id == null && tops_name == null && tops_image == null && tops_id == null){
            all(response);
        }

        //添加
        if (users_id != null && tops_name != null && tops_image != null){
            Users users = new Users();
            users.setUsers_id(Integer.parseInt(users_id));
            Top top = new Top(tops_name,tops_image, users);
            topService.insert(top);
            all(response);
        }

        //修改
        if (tops_id != null && update_tops_name != null && updata_tops_image != null){
            Top top = new Top(Integer.parseInt(tops_id),update_tops_name,updata_tops_image);
            topService.updateTop(top);
            all(response);
        }

        //删除
        if (tops_id != null && update_tops_name == null && updata_tops_image == null &&users_id == null){
            topService.delTopById(Integer.parseInt(tops_id));
            all(response);
        }

    }
    public void all( HttpServletResponse response) throws IOException {
        TopService topService = new TopService();
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        List<Top> allTop = topService.findAllTop();
        String json = gson.toJson(allTop);
        System.out.println(json);
        out.write(json);
        out.close();
    }
}
