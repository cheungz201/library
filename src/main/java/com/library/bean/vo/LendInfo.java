package com.library.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Program: library
 * @Author: Zhang Zhe
 * @Create: 2021-11-21 21:18
 * @Version: 1.0.0
 * @Description: 图书借阅信息
 **/
public class LendInfo implements Serializable {
    private long serNum;
    private String username;
    private String bookName;
    private long readerId;
    private Date lendDate;
    private Date backDate;

    public long getSerNum() {
        return serNum;
    }

    public void setSerNum(long serNum) {
        this.serNum = serNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }
}
