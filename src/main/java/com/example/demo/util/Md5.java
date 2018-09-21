package com.example.demo.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: Md5
 * @date 2018/9/21 19:04
 */
public class Md5 {
    /**
     * 利用MD5进行加密
     */
    private static final String SALT = "this_is_a_salt_string_for_gadhsidgbdfisbgsdfviugviugiorhn";

    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance(SALT);
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
        return newstr;
    }
}