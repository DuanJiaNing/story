package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
@Data
public class StoryDTO implements Serializable {

    private static final long serialVersionUID = 5863607750529596642L;
    private Integer id;
    private Integer writerId;
    private Integer state;
    private String title;
    private String content;
    private String summary;
    private Timestamp releaseDate;
    private Timestamp nearestModifyDate;

}
