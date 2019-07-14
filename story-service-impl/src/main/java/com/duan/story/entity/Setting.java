package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2018/3/26.
 *
 * @author DuanJiaNing
 */
@Data
public class Setting implements Serializable {

    private static final Long serialVersionUID = 3132345087362098153L;
    private Integer id;
    private Integer writerId;
}
