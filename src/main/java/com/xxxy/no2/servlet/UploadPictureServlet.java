package com.xxxy.no2.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UpServlet", value = "/UpServlet")
public class UploadPictureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        FileItemFactory factory = new DiskFileItemFactory();
        // 文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析请求信息
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        // 对请求信息进行判断
        Iterator iter = items.iterator();
        PrintWriter out = response.getWriter();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            // 信息为普通的格式
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String value = item.getString();
                request.setAttribute(fieldName, value);
            }
            // 信息为文件格式
            else {
                String fileName = item.getName();//获得上传图片的名称
                int index = fileName.lastIndexOf("\\");
                fileName = fileName.substring(index + 1);
                request.setAttribute("realFileName", fileName);
                //获取当前项目所在的服务器物理路径getRealPath
                String basePath = "D:\\DeskTop\\yuli\\YuLi\\src\\main\\webapp\\imgs";
                 //String basePath = request.getContextPath()+"/uploadfiles/images";
                log(basePath);
                System.out.println(basePath);//打印当前位置
                File file = new File(basePath, fileName);
                try {

                    item.write(file);
                } catch (Exception e) {
                    e.printStackTrace();
                    log(e.getMessage());
                }
            }
            out.print("上传成功！");
            System.out.println("susses");
            out.flush();
            out.close();
        /*request.setAttribute("msg","文件上传成功!");
        getServletContext().getRequestDispatcher("/UploadPicture.jsp").forward(request, response);*/
        }
    }
}