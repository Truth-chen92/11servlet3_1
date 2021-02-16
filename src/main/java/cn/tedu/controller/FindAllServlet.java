package cn.tedu.controller;

import cn.tedu.dao.HeroDao;
import cn.tedu.entity.Hero;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindAllServlet",urlPatterns = "/findall")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HeroDao dao=new HeroDao();
        List<Hero>list =dao.findAll();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.print("<table border='4'>");
        pw.print("<caption>英雄表</caption>");
        pw.print("<tr><th>id</th><th>名字</th><th>类型</th><th>价格</th></tr>");
        for (Hero h : list) {
            pw.print("<tr>");
            pw.print("<td>"+h.getId()+"</td>");
            pw.print("<td>"+h.getName()+"</td>");
            pw.print("<td>"+h.getType()+"</td>");
            pw.print("<td>"+h.getMoney()+"</td>");
            pw.print("</tr>");
        }
        pw.print("</table>");
        pw.close();

    }
}
