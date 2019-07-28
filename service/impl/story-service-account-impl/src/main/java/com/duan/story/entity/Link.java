package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2019/07/28.
 *
 * @author DuanJiaNing
 */
@Data
public class Link implements Serializable {

    private static final long serialVersionUID = 3154486998146793062L;
    private Integer id;
    private Integer accountId;
    private String icon;
    private String title;
    private String url;
    private String intro;
    private Timestamp insertTime;
    private Timestamp updateTime;
}
