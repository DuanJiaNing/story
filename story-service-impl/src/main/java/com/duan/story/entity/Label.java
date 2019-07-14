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

    private static final long serialVersionUID = 4565919455090875775L;
    private Long id;
    private Long writerId;
    private String title;
    private Timestamp createDate;

}
