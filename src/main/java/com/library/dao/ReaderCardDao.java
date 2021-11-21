package com.library.dao;

import com.library.bean.ReaderCard;
import com.library.bean.ReaderInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author z'z
 */
public interface ReaderCardDao {


    /**
     * 通过账号密码获取匹配的账户
     * @param reader_id
     * @param password
     * @return
     */
    int getIdMatchCount(@Param("reader_id")long reader_id,@Param("password") String password);

    /**
     * 通过id获取读者信息
     * @param reader_id
     * @return
     */
    ReaderCard findReaderByReaderId(@Param("reader_id") long reader_id);

    /**
     * 重设置读者密码
     * @param reader_id
     * @param newPassword
     * @return
     */
    int resetPassword(@Param("reader_id")long reader_id, @Param("password")String newPassword);


    /**
     * 添加读者账户
     * @param readerInfo
     * @param password
     * @return
     */
    int addReaderCard(ReaderInfo readerInfo, @Param("password") String password);

    /**
     * 通过读者id获取读者密码，此方法应被废弃，密码经过混淆，无法得到密码明文
     * @param reader_id
     * @return
     */
    String getPassword(@Param("reader_id") long reader_id);

    /**
     * 删除读者账户
     * @param reader_id
     * @return
     */
    int deleteReaderCard(@Param("reader_id") long reader_id);

    /**
     * 添加读者
     * @param readerCard
     * @return
     */
    int insertReader(@Param("readerCard") ReaderCard readerCard);
}
