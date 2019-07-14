package com.duan.story.util;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
public class CurrentUserThreadLocal {

    private static final ThreadLocal<Integer> currentUid = new ThreadLocal<>();
    private static final ThreadLocal<String> currentLocale = new ThreadLocal<>();
    private static final ThreadLocal<String> currentIp = new ThreadLocal<>();

    public static String getCurrentIp() {
        return currentIp.get();
    }

    public static void setCurrentIp(String ip) {
        currentIp.set(ip);
    }

    public static Integer getCurrentUid() {
        return currentUid.get();
    }

    public static void setCurrentUid(Integer uid) {
        currentUid.set(uid);
    }

    public static String getCurrentLocale() {
        return currentLocale.get();
    }

    public static void setCurrentLocale(String locale) {
        currentLocale.set(locale);
    }
}