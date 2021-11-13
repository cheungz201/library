package xyz;

import com.library.bean.Admin;
import com.library.dao.AdminDao;
import com.library.dao.BookDao;
import com.library.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @Program: library
 * @Author: Zhang Zhe
 * @Create: 2021-11-12 16:37
 * @Version: 1.0.0
 * @Description: admin测试类
 **/


@Slf4j
public class AdminTest extends BaseTest{

    @Autowired
    AdminDao adminDao;

    BookDao bookDao;

    /**
     * 添加账户方法
     */
    //@Test
    public void setAccount(){
        long id = 88888;
        String password = "222222";
        String username = "lllll";
        Admin admin = new Admin();
        admin.setAdminId(id);
        admin.setPassword(Md5Util.MD5encode(id+password));
        admin.setUsername(username);

        int i = adminDao.insertAdmin(admin);
        if (i == 1){
            System.out.println("yes");
        }
    }


    //@Test
    public void logTest() throws IOException {
        log.info("log test");
        bookDao.getAllBooks();
    }
}
