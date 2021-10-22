package com.afuya.service.impl;

import com.afuya.dao.BookDAO;
import com.afuya.dao.impl.BookDAOImpl;
import com.afuya.pojo.Book;
import com.afuya.service.BookService;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/11 10:50 上午
 */
public class BookServiceImpl implements BookService {
    BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookByid(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }
}
