package com.mylearning.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST方法");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("GET方法");
//        ServletContext servletContext = getServletConfig().getServletContext();
//        System.out.println("ServletContext参数url的值是：" + servletContext.getInitParameter("url"));
//        System.out.println("项目工程名为：" + servletContext.getContextPath());
//        // TODO 根据相对路径获取服务器上的绝对的路径
//        System.out.println("项目在硬盘中的存放位置为：" + servletContext.getRealPath("/"));
//        System.out.println("a.html文件的存放位置为：" + servletContext.getRealPath("/a.html"));

        ServletContext context = getServletContext();
        System.out.println("Context 中获取域数据key1的值是：" + context.getAttribute("key1"));
        context.setAttribute("key1", "value1");
        System.out.println("Context 中获取域数据key1的值是：" + context.getAttribute("key1"));
    }
}
