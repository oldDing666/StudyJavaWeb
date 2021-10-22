package com.afuya.test;

import com.afuya.pojo.Book;
import com.afuya.service.BookService;
import com.afuya.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 4:18 下午
 */
public class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "国哥在手，天下我有！", "1125", new BigDecimal(1000000), 100000000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(50);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(50, "社会我国哥，人狠话不多！", "1125", new BigDecimal(999999), 10, 111110, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(48));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, 5));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, 5, 10, 50));
    }
}