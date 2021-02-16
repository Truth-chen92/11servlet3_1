package cn.tedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

//文件上传必须添加以下注解 不然获取不到客户端传递的数据
@MultipartConfig
@WebServlet(name = "UploadServlet", urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取上传的文件
        Part p = request.getPart("pic");
//        获取上传文件的信息
        String info = p.getHeader("content-disposition");
//    获取文件名
//        String fileName = part.getSubmittedFileName();
//        System.out.println(fileName);
//        得到文件的后缀名
        String suffix = info.substring(info.lastIndexOf("."), info.length() - 1);
        System.out.println(suffix);
//        得到唯一文件名 UUID唯一标识符
        String fileName = UUID.randomUUID() + suffix;
        System.out.println(fileName);
//        文件必须保存在Tomcat管辖范围内
//        通过以下代码获取target/工程名/文件夹 路径
        String path=request.getServletContext().getRealPath("images/");
//        创建保存图片文件的images文件夹
        new File(path).mkdirs();
//        把接收到的文本保存到文件夹中
        p.write(path+fileName);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
