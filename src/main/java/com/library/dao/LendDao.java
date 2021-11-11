package com.library.dao;

import com.library.bean.Lend;
import java.util.ArrayList;


public interface LendDao {

    int returnBookOne(final long book_id, long reader_id);

    int returnBookTwo(final long book_id);

    int lendBookOne(final long book_id, final long reader_id);

    int lendBookTwo(final long book_id);

    ArrayList<Lend> lendList();

    ArrayList<Lend> myLendList(final long reader_id);

    int deleteLend(final long ser_num);
}
