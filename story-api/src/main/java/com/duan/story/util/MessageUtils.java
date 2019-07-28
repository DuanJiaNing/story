package com.duan.story.util;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class MessageUtils {

    public static String getMessage(String code) {
        return getMessage(code, null);
    }

    public static String getMessage(String code, Object... args) {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
