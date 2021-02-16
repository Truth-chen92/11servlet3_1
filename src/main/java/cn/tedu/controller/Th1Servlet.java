package cn.tedu.controller;

import cn.tedu.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Th1Servlet", urlPatterns = "/th1")
public class Th1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "刘德华";
        ArrayList<String>list=new ArrayList<>();
        list.add("刘备");
        list.add("关羽");
        list.add("张飞");
//        要想把数据和页面整合到一起 需要先将数据装进Context对象中 此对象可以理解为一个容器
        Context context=new Context();
        context.setVariable("list",list);
//        把数据以键值对形式添加到容器中
        context.setVariable("name",name);
//        通过模板引擎工具类 将页面和数据整合到一起 并返回给客户端
        ThUtils.print("th1.html",context,response );

    }
}
