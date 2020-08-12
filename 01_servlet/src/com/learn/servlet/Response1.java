package com.learn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Response1接受请求");
//        resp.setStatus(302);
//        resp.setHeader("Location","http://localhost:8087/01_servlet/response2");
        System.out.println("调用Redirect");
        resp.sendRedirect("http://localhost:8087/01_servlet/response2"); 
    }
}
