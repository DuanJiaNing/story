package com.duan.story.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class SpringUtils {
    private static ApplicationContext applicationContext = null;

    public SpringUtils() {
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // ApplicationContextAware#setApplicationContext 中进行赋值
    public static void setApplicationContext(ApplicationContext context) throws BeansException {
        if (applicationContext == null) {
            applicationContext = context;
        }
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
