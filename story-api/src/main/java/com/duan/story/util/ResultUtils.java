package com.duan.story.util;

import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.restful.ResultBean;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class ResultUtils {

    public static ResultBean success() {
        return success(null);
    }

    public static ResultBean success(Object data) {
        ResultBean model = new ResultBean();
        model.setData(data);
        model.setCode(ResultModel.SUCCESS);
        return model;
    }

    public static ResultBean fail(int msgCode) {
        String msg = MessageUtils.getMessage(msgCode + "");

        ResultBean model = new ResultBean();
        model.setMsg(msg);
        model.setCode(ResultModel.FAIL);
        return model;
    }

    public static boolean isSuccess(ResultModel model) {
        return model.getCode().equals(ResultModel.SUCCESS);
    }
}
