package cn.tedu.controller;

import cn.tedu.dao.HeroDao;
import cn.tedu.entity.Hero;
import cn.tedu.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewFindAllServlet",urlPatterns = "/newfindall")
public class NewFindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeroDao dao=new HeroDao();
        List<Hero>list = dao.findAll();
//        把数据装进容器
        Context context = new Context();
        context.setVariable("list",list);
        ThUtils.print("list.html",context,response);




    }
}
