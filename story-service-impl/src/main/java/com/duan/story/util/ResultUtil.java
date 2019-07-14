package com.duan.story.util;

import com.duan.story.common.ResultModel;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class ResultUtil {

    public static ResultModel parameterRequireNoNull() {
        String msg = MessageUtil.getMessage(5000);
        return ResultModel.fail(msg, 5000);
    }

    public static <T> ResultModel<T> success(T data) {
        return ResultModel.success(data);
    }

    public static ResultModel fail() {
        return ResultModel.fail();
    }
}
