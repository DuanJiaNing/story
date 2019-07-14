package com.duan.story.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2017/12/13.
 *
 * @author DuanJiaNing
 */

@Data
public class ResultModel<T> implements Serializable {

    private static final long serialVersionUID = 4780382608978369566L;

    public static final int SUCCESS = 200;

    public static final int FAIL = 500;
    public static final int NULL = 501;

    private Object msg;
    private int code = SUCCESS;
    private T data;

    public ResultModel() {
    }

    public ResultModel(T data) {
        this.data = data;
    }

    public ResultModel(Object msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public static ResultModel success() {
        return new ResultModel();
    }

    public static <T> ResultModel<T> success(T data) {
        ResultModel<T> model = new ResultModel<>(data);
        model.setCode(SUCCESS);
        return model;
    }

    public static ResultModel fail() {
        ResultModel model = new ResultModel(null, FAIL);
        return model;
    }

    public static ResultModel null_(Mode mode) {
        ResultModel model = new ResultModel<>(mode, NULL);
        return model;
    }

    public static ResultModel fail(String msg, int code) {
        ResultModel model = new ResultModel<>(msg, code);
        return model;
    }

    public boolean isSuccess() {
        return code == SUCCESS;
    }

}
