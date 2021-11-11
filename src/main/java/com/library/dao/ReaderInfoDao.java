package com.library.dao;

import com.library.bean.ReaderInfo;
import java.util.ArrayList;

public interface ReaderInfoDao {

    ArrayList<ReaderInfo> getAllReaderInfo();

    ReaderInfo findReaderInfoByReaderId(final long reader_id);

    int deleteReaderInfo(final long reader_id);

    int editReaderInfo(final ReaderInfo readerInfo);

    int editReaderCard(final ReaderInfo readerInfo);

    long addReaderInfo(final ReaderInfo readerInfo);
}
