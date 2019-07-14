package com.duan.story.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2019/2/22.
 *
 * @author DuanJiaNing
 */
public class Util {

    public static boolean isArrayEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isArrayEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }

    public static HttpServletRequest getServletRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
    }

    public static HttpServletResponse getServletResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getResponse();
    }

    public static String getCookie(String key) {
        HttpServletRequest request = getServletRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }

        return null;

    }

    public static String getToken() {
        HttpServletRequest request = getServletRequest();
        String token = request.getHeader("token");
        if (token == null) {
            token = request.getParameter("token");
        }

        if (token == null) {
            token = getCookie("token");
        }

        return token;
    }

}
