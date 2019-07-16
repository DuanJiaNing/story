package com.duan.story.util;

import com.duan.story.common.ResultModel;
import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class ResultUtil {

    public static <T> ResultModel<T> success(T data) {
        return ResultModel.success(data);
    }

    public static ResultModel fail() {
        return fail(5001);
    }

    public static ResultModel fail(int code) {
        String msg = MessageUtil.getMessage(code);
        return ResultModel.fail(msg, code);
    }

    public static <T> boolean isPageEmpty(PageInfo<T> info) {
        return info == null || CollectionUtils.isEmpty(info.getList());
    }
}
