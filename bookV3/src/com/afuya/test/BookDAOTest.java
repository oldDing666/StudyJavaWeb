package com.afuya.test;

import com.afuya.dao.BookDAO;
import com.afuya.dao.impl.BookDAOImpl;
import com.afuya.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/11 10:16 上午
 */
public class BookDAOTest {
    BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void addBook() {
        Book book = new Book(null, "阿福为什么这么帅！", new BigDecimal(99.9), "afuya", 100000, 25, null);
        bookDAO.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookDAO.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        Book book = new Book(21, "大家为什么这么帅！", new BigDecimal(99.9), "afuya", 100000, 25, null);
        bookDAO.updateBook(book);
    }

    @Test
    public void queryBookByid() {
        Book book = bookDAO.queryBookByid(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDAO.queryBooks()) {
            System.out.println(book);
        }
    }
}