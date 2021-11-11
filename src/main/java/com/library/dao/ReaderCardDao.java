package com.library.dao;

import com.library.bean.ReaderCard;
import com.library.bean.ReaderInfo;
import org.apache.ibatis.annotations.Param;

public interface ReaderCardDao {

    int getIdMatchCount(@Param("reader_id")long reader_id,@Param("password") String password);

    ReaderCard findReaderByReaderId(@Param("reader_id") long reader_id);

    int resetPassword(@Param("reader_id")long reader_id, @Param("password")String newPassword);

    int addReaderCard(ReaderInfo readerInfo, String password);

    String getPassword(long reader_id);

    int deleteReaderCard(long reader_id);
}
