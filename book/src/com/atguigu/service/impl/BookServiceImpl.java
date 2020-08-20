package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImpl implements BookService {


    BookDao dao = new BookDaoImpl();


    @Override
    public void addBook(Book book) {
        dao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        dao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        dao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return dao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return dao.queryForBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        // 设置当前页码
        page.setPageNo(pageNo);
        // 设置每页的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = dao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) pageTotal++;

        page.setPageTotal(pageTotal);

        // 求当前页的开始索引
        int begin = (pageNo - 1) * pageSize;
        // 查询当前页数据
        List<Book> items = dao.queryForPageItems(begin, pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        // 设置当前页码
        page.setPageNo(pageNo);
        // 设置每页的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = dao.queryForPageByPriceCount(min,max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) pageTotal++;

        page.setPageTotal(pageTotal);

        // 求当前页的开始索引
        int begin = (pageNo - 1) * pageSize;
        // 查询当前页数据
        List<Book> items = dao.queryForPageByPriceItems(begin, pageSize,min,max);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
