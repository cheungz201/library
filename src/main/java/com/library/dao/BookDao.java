package com.library.dao;

import com.library.bean.Book;
import java.util.ArrayList;

public interface BookDao {


    int matchBook(final String searchWord);

    ArrayList<Book> queryBook(final String searchWord);

    ArrayList<Book> getAllBooks();

    int addBook(final Book book);

    Book getBook(final long bookId);

    int editBook(final Book book);

    int deleteBook(final long bookId) ;

}
