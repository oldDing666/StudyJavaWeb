package com.afuya.dao;

import com.afuya.pojo.Book;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/11 9:59 上午
 */
public interface BookDAO {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookByid(Integer id);

    public List<Book> queryBooks();
}
