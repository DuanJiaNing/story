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

    private static final int SUCCESS = 200;
    private static final int FAIL = 500;

    public static ResultModel success(Object data) {
        ResultModel model = new ResultModel();
        model.setData(data);
        model.setCode(SUCCESS);
        return model;
    }

    public static ResultModel fail(int msgCode) {
        String msg = MessageUtil.getMessage(msgCode + "");

        ResultModel model = new ResultModel();
        model.setMsg(msg);
        model.setCode(FAIL);
        return model;
    }

    public static <T> boolean isPageEmpty(PageInfo<T> info) {
        return info == null || CollectionUtils.isEmpty(info.getList());
    }
}
