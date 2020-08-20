package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService service = new BookServiceImpl();


    /**
     * 添加图书
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        book.setName(req.getParameter("name"));
        book.setAuthor(req.getParameter("author"));
        book.setPrice(BigDecimal.valueOf(Double.parseDouble(req.getParameter("price"))));
        book.setSales(Integer.parseInt(req.getParameter("sales")));
        book.setStock(Integer.parseInt(req.getParameter("stock")));

        service.addBook(book);

        // 如果采用请求转发，会出现问题
        // 用户在发起最后一次请求时，浏览器会记住该请求。当用户按下F5时，浏览器会自动发起最后一次的请求。
        // 如果采用请求转发，则浏览器记住的最后一次请求就是add的请求，当用户按下F5后，又会重新进入add方法，导致重复添加数据
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");


    }

    /**
     * 删除图书
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要删除的图书ID
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        // 执行删除操作
        service.deleteBookById(id);

        // 请求重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

    }

    /**
     * 更新图书信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        book.setId(Integer.parseInt(req.getParameter("id")));
        book.setName(req.getParameter("name"));
        book.setAuthor(req.getParameter("author"));
        book.setPrice(BigDecimal.valueOf(Double.parseDouble(req.getParameter("price"))));
        book.setSales(Integer.parseInt(req.getParameter("sales")));
        book.setStock(Integer.parseInt(req.getParameter("stock")));

        service.updateBook(book);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    /**
     * 获取全部图书列表
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询全部图书列表
        List<Book> list = service.queryBooks();

        // 将列表放入request域中
        req.setAttribute("list", list);

        // 请求转发至jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * 获取单个图书信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要查询的图书ID
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Book book = service.queryBookById(id);

        req.setAttribute("book", book);

        // 转发至编辑页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数 pageNo, pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        // 调用service.page(pageNo,pageSize)方法
        Page<Book> page = service.page(pageNo, pageSize);

        page.setUrl("manager/bookServlet?action=page");

        // 保存page对象到request域中
        req.setAttribute("page",page);

        // 请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

}
