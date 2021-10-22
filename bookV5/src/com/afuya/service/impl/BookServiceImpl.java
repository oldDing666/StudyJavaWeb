package com.afuya.service.impl;

import com.afuya.dao.BookDao;
import com.afuya.dao.impl.BookDaoImpl;
import com.afuya.pojo.Book;
import com.afuya.pojo.Page;
import com.afuya.service.BookService;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 3:10 下午
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        // 总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        // 总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 设置pageNo的属性值，要放在pageTotal后
        page.setPageNo(pageNo);
        // 要先将pageNo属性赋值给page对象，再通过get方法取值。因为在set方法中会对范围做一次处理
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> books = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(books);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        page.setPageSize(pageSize);
        // 总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);
        // 总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 设置pageNo的属性值，要放在pageTotal后
        page.setPageNo(pageNo);

        // 要先将pageNo属性赋值给page对象，再通过get方法取值。因为在set方法中会对范围做一次处理
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> books = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(books);
        return page;
    }
}
