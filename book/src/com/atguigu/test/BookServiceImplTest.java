package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImplTest extends TestCase {

    BookService bookService = new BookServiceImpl();

    public void testAddBook() {
        bookService.addBook(new Book(null,"当你像鸟飞往你的山","塔拉",new BigDecimal(59),7897,234,null));
    }

    public void testDeleteBookById() {
        bookService.deleteBookById(6);
    }

    public void testUpdateBook() {
        bookService.updateBook(new Book(22,"当你像鸟飞往你的山","塔拉",new BigDecimal(59),8902,234,null));
    }

    public void testQueryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    public void testQueryBooks() {
        List<Book> books = bookService.queryBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void testPage(){
        System.out.println(bookService.page(1,4));
    }


}