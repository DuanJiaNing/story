package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/12.
 *
 * @author DuanJiaNing
 */
@Data
public class Label implements Serializable {

    private static final Long serialVersionUID = 4565919455090875775L;
    private Integer id;
    private Integer writerId;
    private String title;
    private Timestamp createDate;

}
