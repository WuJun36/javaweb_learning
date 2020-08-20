package com.atguigu.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 1 获取要下载的文件名
        String downloadFileName = "渽民.jpg";

//        TODO 2、读取要下载的文件内容
        ServletContext servletContext = getServletContext();

        // 获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/resources/" + downloadFileName);

        //        TODO 4、在回传前，通过响应头，告诉客户端响应的文件类型是什么
        resp.setContentType(mimeType);

        InputStream resourceAsStream = servletContext.getResourceAsStream("/resources/" + downloadFileName);
        ServletOutputStream outputStream = resp.getOutputStream();

        //        TODO 5、告诉客户端，收到的数据是用于下载使用（使用响应头）

        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downloadFileName, "UTF-8"));
        //        TODO 3、把下载的文件内容回传给客户端

        //读取resourceAsStream全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);


    }
}
