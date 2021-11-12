package com;

import com.library.bean.Admin;
import com.library.dao.AdminDao;
import com.library.utils.Md5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Program: library
 * @Author: Zhang Zhe
 * @Create: 2021-11-12 16:37
 * @Version: 1.0.0
 * @Description:
 **/
public class AdminTest extends BaseTest{

    @Autowired
    AdminDao adminDao;

    @Test
    public void setAccount(){
        long id = 137948510;
        String password = "123456";
        String username = "cheungz";
        Admin admin = new Admin();
        admin.setAdminId(id);
        admin.setPassword(Md5Util.MD5encode(id+password));
        admin.setUsername(username);

        int i = adminDao.insertAdmin(admin);
        System.out.println(i);
    }
}
