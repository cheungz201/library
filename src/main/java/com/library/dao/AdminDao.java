package com.library.dao;

import com.library.bean.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author z'z
 */
public interface AdminDao {

    /**
     * 使用账号密码获取匹配账户
     * @param adminId
     * @param password
     * @return int
     */
    int getMatchCount(@Param("admin_id")long adminId, @Param("password")String password);

    /**
     *  重置密码
     * @param adminId
     * @param password
     * @return
     */
    int resetPassword(@Param("admin_id")long adminId, @Param("password")String password);

    /**
     * 使用id获取密码
     * @param adminId
     * @return
     */
    String getPassword(@Param("admin_id")long adminId);

    /**
     * 通过id获取用户名
     * @param adminId
     * @return
     */
    String getUsername(@Param("admin_id")long adminId);

    /**
     * 得到一个账号完整信息
     * @param id
     * @param password
     * @return
     */
    Admin getAdmin(@Param("admin_id") long id,@Param("password") String password);


    /**
     * 插入一个账户
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);
}
