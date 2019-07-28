package com.duan.story.common.util;


/**
 * Created on 2018/5/30.
 *
 * @author DuanJiaNing
 */
public class TokenUtil {

    private static final String key = "abcdefghijklmnopqrstuvwxyz12";

    private static final String separator = ":";

    private static final String appName = "story";

    private static final String SUFFIX = "token";

    /**
     * 获取加密 token
     */
    public static String getToken(Integer uid) {
        return AESUtil.aesEncrypt(tokenContent(uid), key);
    }

    /**
     * 获取 token key
     */
    public static String getTokenKey(Integer uid) {
        return appName + separator + SUFFIX + separator + uid;
    }

    private static String tokenContent(Integer uid) {
        return String.valueOf(System.currentTimeMillis()) + separator + uid;
    }

    /**
     * 解密
     */
    public static Integer decode(String token) throws Exception {

        String str = new String(token.getBytes("UTF-8"), "ISO-8859-1");

        // 如果解密失败抛出异常
        String decodeStr = AESUtil.aesDecrypt(str, key);
        String[] content = decodeStr.split(separator);

        String time = content[0];
        String uid = content[1];

        return Integer.valueOf(uid);

    }

}
