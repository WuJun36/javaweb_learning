package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.atguigu.web.BaseServlet;
import com.atguigu.web.BookServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    private BookService service = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数 pageNo, pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        // 调用service.page(pageNo,pageSize)方法
        Page<Book> page = service.page(pageNo, pageSize);

        page.setUrl("client/bookServlet?action=page");

        // 保存page对象到request域中
        req.setAttribute("page", page);

        // 请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求参数 pageNo, pageSize, min, max
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        Page<Book> page = service.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        if (req.getParameter("min") != null) sb.append("&min=").append(req.getParameter("min"));
        if (req.getParameter("max") != null) sb.append("&max=").append(req.getParameter("max"));

        page.setUrl(sb.toString());


        // 保存page对象到request域中
        req.setAttribute("page", page);

        // 请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);


    }

}
