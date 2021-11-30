package xyz;

import com.library.bean.Admin;
import com.library.bean.ReaderCard;
import com.library.bean.vo.LendInfo;
import com.library.dao.AdminDao;
import com.library.dao.LendDao;
import com.library.dao.ReaderCardDao;
import com.library.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @Program: library
 * @Author: Zhang Zhe
 * @Create: 2021-11-12 16:37
 * @Version: 1.0.0
 * @Description: admin测试类
 **/


@Slf4j
public class AdminTest extends BaseTest {

    @Autowired
    AdminDao adminDao;

    @Autowired
    ReaderCardDao readerCardDao;

    @Autowired
    LendDao lendDao;

    /**
     * 添加管理员账户
     */
    @Test
    public void setAdminAccount() {
        long id = 888888;
        String password = "123456";
        String username = "Zhang Zhe";
        Admin admin = new Admin();
        admin.setAdminId(id);
        admin.setPassword(Md5Util.MD5encode(id + password));
        admin.setUsername(username);

        int i = adminDao.insertAdmin(admin);
        if (i == 1) {
            System.out.println("yes");
        }
    }

    /**
     * 添加读者账户
     */
    //@Test
    public void setReaderAccount() {
        long id = 20000;
        String password = "123456";
        String username = "cheungZ";
        ReaderCard readerCard = new ReaderCard();
        readerCard.setReaderId(id);
        readerCard.setPassword(Md5Util.MD5encode(id + password));
        readerCard.setName(username);
        int i = readerCardDao.insertReader(readerCard);
        if (i == 1) {
            System.out.println("yes");
        }

    }

    @Test
    public void bookTimeTest() {
        ArrayList<LendInfo> lendInfos = lendDao.queryLendListByReadId(10000);
        for (LendInfo info : lendInfos){
            System.out.println(info.getBookName());
        }
    }
}
