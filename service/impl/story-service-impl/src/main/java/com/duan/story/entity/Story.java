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
public class Story implements Serializable {

    private static final Long serialVersionUID = -34589740054806375L;
    private Integer id;
    private Integer writerId;
    private Integer state;
    private String title;
    private String content;
    private String summary;
    private Timestamp releaseDate;
    private Timestamp nearestModifyDate;

}
