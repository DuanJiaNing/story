package com.duan.story.util;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class Util {

    /**
     * 将字符串不可逆转化为 sha 字节数组
     *
     * @param str 字符串
     * @return 转化结果
     */
    public static byte[] toSha(String str) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(str.getBytes());
        return sha.digest();
    }

    public static boolean isStringBlank(String str) {
        return StringUtils.isEmpty(str) || str.trim().equals("");
    }
}
