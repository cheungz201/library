package com.library.utils;

import org.apache.commons.lang3.StringUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Program: library
 * @Author: Zhang Zhe
 * @Create: 2021-11-12 16:14
 * @Version: 1.0.0
 * @Description:
 **/
public class Md5Util {

    /**
     *
     * @param source
     * @return md5散列之后的字符串
     */
    public static String MD5encode(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        byte[] encode = messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
