package com.afuya.test;

import com.afuya.pojo.Book;
import com.afuya.service.BookService;
import com.afuya.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/11 10:52 上午
 */
public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        Book book = new Book(null, "阿福牛逼", new BigDecimal(59), "阿福呀", 99999, 100, null);
        bookService.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        Book book = new Book(22, "阿福优秀", new BigDecimal(59), "阿福呀", 99999, 100, null);
        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }
}