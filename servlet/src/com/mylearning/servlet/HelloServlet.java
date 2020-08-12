package com.mylearning.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {


    public HelloServlet() {
        System.out.println("1、构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2、init初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3、service === Hello Servlet被访问了");
        //类型转换（有getMethod）方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求方法
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        if("GET".equals(method)){
            System.out.println("get请求");
        } else if ("POST".equals(method)){
            System.out.println("post请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、destroy销毁方法");
    }
}
