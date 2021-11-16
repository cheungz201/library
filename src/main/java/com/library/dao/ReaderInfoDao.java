package com.library.dao;

import com.library.bean.ReaderInfo;
import java.util.ArrayList;

/**
 * @author z'z
 */
public interface ReaderInfoDao {

    /**
     * 得到所有读者信息
     * @return
     */
    ArrayList<ReaderInfo> getAllReaderInfo();

    /**
     * 通过读者id得到读者信息
     * @param reader_id
     * @return
     */
    ReaderInfo findReaderInfoByReaderId(final long reader_id);

    /**
     * 通过id删除读者信息
     * @param reader_id
     * @return
     */
    int deleteReaderInfo(final long reader_id);

    /**
     * 编辑读者信息
     * @param readerInfo
     * @return
     */
    int editReaderInfo(final ReaderInfo readerInfo);

    /**
     * 编辑读者姓名
     * @param readerInfo
     * @return
     */
    int editReaderCard(final ReaderInfo readerInfo);

    /**
     * 添加读者信息
     * @param readerInfo
     * @return
     */
    long addReaderInfo(final ReaderInfo readerInfo);
}
