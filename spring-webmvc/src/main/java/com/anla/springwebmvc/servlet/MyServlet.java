package com.anla.springwebmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/11 19:29
 **/
@WebServlet(urlPatterns = "/myservlelt")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type","text/html;charset=utf-8");
        response.getWriter().println("my springboot servlet……测试中文输出");
        response.getWriter().flush();
        response.getWriter().close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
