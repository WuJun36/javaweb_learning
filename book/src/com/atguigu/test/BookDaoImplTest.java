package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoImplTest extends TestCase {

    BookDao dao = new BookDaoImpl();

    public void testAddBook() {
        dao.addBook(new Book(null, "刑法格言的展开", "张明楷", new BigDecimal(49.0), 20000, 5000, null));
    }

    public void testDeleteBookById() {

        dao.deleteBookById(7);
    }

    public void testUpdateBook() {
        dao.updateBook(new Book(3, "大败局", "吴晓波", new BigDecimal(68), 490, 30, null));
    }

    public void testQueryBookById() {
        System.out.println(dao.queryBookById(3));
    }

    public void testQueryForBooks() {
        List<Book> books = dao.queryForBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void testQueryForPageTotalCount() {
        System.out.println(dao.queryForPageTotalCount());
    }

    @Test
    public void testQueryForPageItems() {
        List<Book> list = dao.queryForPageItems(8, Page.PAGE_SIZE);
        list.forEach(System.out::println);

    }

    @Test
    public void testQueryForPageByPriceCount() {
        Integer count = dao.queryForPageByPriceCount(0, 20);
        System.out.println(count);
    }

    @Test
    public void testQueryForPageByPriceItems() {
        List<Book> list = dao.queryForPageByPriceItems(3, 2, 10, 50);
        list.forEach(System.out::println);
    }
}