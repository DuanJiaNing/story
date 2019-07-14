package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/15.
 *
 * @author DuanJiaNing
 */
@Data
public class CategoryDTO implements Serializable {

    private static final Long serialVersionUID = 6659348430081547146L;
    private Integer id;
    private Integer writerId;
    private Integer storyAmount;
    private String title;
    private String bewrite;
    private Timestamp createDate;
    private String icon;

}
