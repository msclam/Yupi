package com.atguigu7.daoFinal;

import com.atguigu7.daoFinal.bean.Book;

import java.sql.Connection;
import java.util.List;

/**
 * @author lanjuwen
 * @create 2021-12-30  0:04
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> getBooks(Connection conn) {
        List<Book> beanList = null;
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from books";
        beanList = getBeanList(conn, sql);
        return beanList;
    }

    @Override
    public void saveBook(Connection conn, Book book) {
        String sql = "insert into books(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
        update(conn, sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),book.getImgPath());
    }

    @Override
    public void deleteBookById(Connection conn, String bookId) {
        // 写sql语句
        String sql = "DELETE FROM books WHERE id = ?";
        // 调用BaseDao中通用增删改的方法
        update(conn,sql, bookId);
    }

    @Override
    public Book getBookById(Connection conn, String bookId) {
        Book book = null;
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from books where id = ?";
        book = getBean(conn, sql, bookId);
        return book;
    }

    @Override
    public void updateBook(Connection conn, Book book) {
        String sql = "update books set title = ? , author = ? , price = ? , sales = ? , stock = ? where id = ?";
        update(conn, sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getId());
    }
}
