package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryForBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(Integer begin, Integer pageSize);

    Integer queryForPageByPriceCount(int min, int max);

    List<Book> queryForPageByPriceItems(int begin, int pageSize, int min, int max);
}
