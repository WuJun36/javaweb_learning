package com.mylearning.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletRequest的常用方法
 */
public class HttpRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("项目运行的相对路径：" + request.getRequestURI());
        System.out.println("项目运行的绝对路径：" + request.getRequestURL());
        System.out.println("请求头user-agent参数的值：" + request.getHeader("user-agent"));
        System.out.println("请求的方法：" + request.getMethod());
    }
}
