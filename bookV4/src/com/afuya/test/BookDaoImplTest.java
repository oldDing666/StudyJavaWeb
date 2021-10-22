package com.afuya.test;

import com.afuya.dao.BookDao;
import com.afuya.dao.impl.BookDaoImpl;
import com.afuya.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 2:50 下午
 */
public class BookDaoImplTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "国哥为什么这么帅！", "191125", new BigDecimal(9999), 1100000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(49);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(48, "阿福大帅比！", "191125", new BigDecimal(9999), 1100000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(48));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book : bookDao.queryForPageItems(10, 5)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDao.queryForPageItemsByPrice(0, 5, 10, 50)) {
            System.out.println(book);
        }
    }
}