package com.duan.story.common.util;

import com.duan.story.common.ResultModel;
import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class ResultUtils {

    public static ResultModel success(Object data) {
        ResultModel model = new ResultModel();
        model.setData(data);
        model.setCode(ResultModel.SUCCESS);
        return model;
    }

    public static ResultModel fail() {
        return fail("internal error");
    }

    public static ResultModel fail(String msg) {
        ResultModel model = new ResultModel();
        model.setMsg(msg);
        model.setCode(ResultModel.FAIL);
        return model;
    }

    public static ResultModel fail(String msg, Throwable e) {
        e.printStackTrace();
        return fail(msg);
    }

    public static <T> boolean isPageEmpty(PageInfo<T> info) {
        return info == null || CollectionUtils.isEmpty(info.getList());
    }
}
