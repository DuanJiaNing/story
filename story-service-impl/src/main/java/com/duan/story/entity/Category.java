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
public class Category implements Serializable {

    private static final Long serialVersionUID = -7413640669767387180L;
    private Integer id;
    private Integer writerId;
    private String icon;
    private String title;
    private String bewrite;
    private Timestamp createDate;

}
