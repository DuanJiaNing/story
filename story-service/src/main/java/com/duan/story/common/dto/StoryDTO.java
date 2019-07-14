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

    private Long id;
    private Long writerId;
    private Integer state;
    private String title;
    private String content;
    private String summary;
    private Timestamp releaseDate;
    private Timestamp nearestModifyDate;

}
