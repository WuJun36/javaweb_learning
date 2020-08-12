package com.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看参数：" + username);

        // 查看办事的章
        Object key = req.getAttribute("key");
        System.out.println("Servlet盖的章为：" + key.toString());

        // Servlet2办理业务
        System.out.println("Servlet2办理业务");
    }
}
