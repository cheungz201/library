package com.library.service;

import com.library.bean.Admin;
import com.library.bean.ReaderCard;
import com.library.dao.AdminDao;
import com.library.dao.ReaderCardDao;
import com.library.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author z'z
 */
@Service
public class LoginService {

    @Autowired
    private ReaderCardDao readerCardDao;

    @Autowired
    private AdminDao adminDao;


    public String getAdminUsername(long adminId) {
        return adminDao.getUsername(adminId);
    }

    public ReaderCard findReaderCardByReaderId(long readerId){
        return readerCardDao.findReaderByReaderId(readerId);
    }


    public boolean adminRePassword(long adminId, String newPassword){
        return adminDao.resetPassword(adminId,newPassword)>0;
    }
    public String getAdminPassword(long adminId){
        return adminDao.getPassword(adminId);
    }

    public boolean readerRePassword(long readerId, String newPassword) {
        return readerCardDao.resetPassword(readerId, newPassword) > 0;
    }

    public String getReaderPassword(long readerId) {
        return readerCardDao.getPassword(readerId);
    }

    public Admin Login(long id,String password){
        return adminDao.getAdmin(id, Md5Util.MD5encode(id+password));
    }

}
