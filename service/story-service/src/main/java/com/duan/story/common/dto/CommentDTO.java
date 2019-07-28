package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/14.
 *
 * @author DuanJiaNing
 */
@Data
public class CommentDTO implements Serializable {

    private static final Long serialVersionUID = 8591361444007793478L;
    private Integer id;
    private Integer storyId;
    private Integer spokesmanId;
    private String content;
    private Timestamp releaseDate;
    private int state;

}
