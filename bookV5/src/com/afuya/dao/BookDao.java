package com.afuya.dao;

import com.afuya.pojo.Book;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 11:00 上午
 */
public interface BookDao {
    /**
     * 增
     *
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 删
     *
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 改
     *
     * @param book
     * @return
     */
    public int updateBook(Book book);

    /**
     * 查一行
     *
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查多行
     *
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 查一个值
     *
     * @return
     */
    public Integer queryForPageTotalCount();

    /**
     * 查询多行，一页的数据
     *
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Book> queryForPageItems(int begin, int pageSize);

    /**
     * 查询价格范围内的所有记录总数
     *
     * @param min
     * @param max
     * @return
     */
    public Integer queryForPageTotalCountByPrice(int min, int max);

    /**
     * 查询价格范围内的所有记录，再分页显示
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
