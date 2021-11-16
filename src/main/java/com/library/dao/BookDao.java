package com.library.dao;

import com.library.bean.Book;
import java.util.ArrayList;

/**
 * @author z'z
 */
public interface BookDao {


    /**
     * 通过书名查询匹配到的书记
     * @param searchWord
     * @return
     */
    int matchBook(final String searchWord);

    ArrayList<Book> queryBook(final String searchWord);

    /**
     * 得到所有的书籍
     * @return
     */
    ArrayList<Book> getAllBooks();

    /**
     * 添加书籍
     * @param book
     * @return
     */
    int addBook(final Book book);

    /**
     * 通过书籍的id获取书籍
     * @param bookId
     * @return
     */
    Book getBook(final long bookId);

    /**
     * 更新书籍信息
     * @param book
     * @return
     */
    int editBook(final Book book);

    /**
     * 删除书籍
     * @param bookId
     * @return
     */
    int deleteBook(final long bookId) ;

}
