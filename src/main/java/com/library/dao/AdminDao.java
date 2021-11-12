package com.library.dao;

import com.library.bean.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    int getMatchCount(@Param("admin_id")long admin_id, @Param("password")String password);

    int resetPassword(@Param("admin_id")long admin_id, @Param("password")String password);

    String getPassword(@Param("admin_id")long admin_id);

    String getUsername(@Param("admin_id")long admin_id);

    Admin getAdmin(@Param("admin_id") long id,@Param("password") String password);

    int insertAdmin(Admin admin);
}
