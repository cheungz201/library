package com.library.dao;

import com.library.bean.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author z'z
 */
public interface AdminDao {

    /**
     * 使用账号密码获取匹配账户
     * @param admin_id
     * @param password
     * @return int
     */
    int getMatchCount(@Param("admin_id")long admin_id, @Param("password")String password);

    /**
     *  重置密码
     * @param admin_id
     * @param password
     * @return
     */
    int resetPassword(@Param("admin_id")long admin_id, @Param("password")String password);

    /**
     * 使用id获取密码
     * @param admin_id
     * @return
     */
    String getPassword(@Param("admin_id")long admin_id);

    /**
     * 通过id获取用户名
     * @param admin_id
     * @return
     */
    String getUsername(@Param("admin_id")long admin_id);

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
