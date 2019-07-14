package com.duan.story.common.exception;

/**
 * Created on 2017/12/20.
 *
 * @author DuanJiaNing
 */
public class InternalException extends RuntimeException {

    /**
     * 异常对应的编号，子类需要赋一个对应自己错误的唯一值
     */
    protected final int code;

    public InternalException(int code) {
        this.code = code;
    }

    public InternalException(String message, int code) {
        super(message);
        this.code = code;
    }

    public InternalException(String message, int code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
