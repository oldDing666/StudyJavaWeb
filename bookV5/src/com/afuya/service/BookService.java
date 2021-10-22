package com.afuya.service;

import com.afuya.pojo.Book;
import com.afuya.pojo.Page;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 3:09 下午
 */
public interface BookService {
    /**
     * 增加书籍信息
     *
     * @param book
     */
    public void addBook(Book book);

    /**
     * 根据id删除书
     *
     * @param id
     */
    public void deleteBookById(Integer id);

    /**
     * 修改书的信息
     *
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 查找一本书的信息
     *
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查找所有书的信息
     *
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 分页，根据起始下标和页面大小分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> page(int pageNo, int pageSize);

    /**
     * 筛选价格后再分页
     *
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
