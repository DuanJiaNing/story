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

    private static final Long serialVersionUID = 4780382608978369566L;

    private Object msg;
    private Integer code;
    private T data;

}
