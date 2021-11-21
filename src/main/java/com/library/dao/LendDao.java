package com.library.dao;

import com.library.bean.Lend;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;


/**
 * @author z'z
 */
public interface LendDao {

    int returnBookOne(@Param("book_id") final long book_id, @Param("reader_id") long reader_id);

    /**
     * 增加书籍余量
     * @param book_id
     * @return
     */
    int returnBookTwo(@Param("book_id") final long book_id);

    /**
     * 插入书籍的借阅信息
     * @param book_id
     * @param reader_id
     * @return
     */
    int lendBookOne(@Param("book_id") final long book_id, @Param("reader_id") final long reader_id);

    /**
     * 减少书籍余量
     * @param book_id
     * @return
     */
    int lendBookTwo(@Param("book_id") final long book_id);

    /**
     * 查询所有书籍借阅信息
     * @return
     */
    ArrayList<Lend> lendList();

    /**
     * 查询指定读者的借阅信息
     * @param reader_id
     * @return
     */
    ArrayList<Lend> myLendList(@Param("reader_id")final long reader_id);

    /**
     * 删除指定书籍的借阅信息
     * @param ser_num
     * @return
     */
    int deleteLend(@Param("ser_num")final long ser_num);
}
