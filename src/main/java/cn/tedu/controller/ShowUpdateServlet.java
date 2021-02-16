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

@WebServlet(name = "ShowUpdateServlet",urlPatterns = "/showupdate")
public class ShowUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        System.out.println("修改ID为"+id);
        HeroDao dao=new HeroDao();
        Hero hero=dao.findByID(id);
        Context context = new Context();
        context.setVariable("hero",hero);
        ThUtils.print("update.html",context,response);







    }
}
