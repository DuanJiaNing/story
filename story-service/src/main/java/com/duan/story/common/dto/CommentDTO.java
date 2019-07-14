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

    private static final long serialVersionUID = 8591361444007793478L;
    private Long id;
    private Long storyId;
    private WriterDTO spokesman;
    private String content;
    private Timestamp releaseDate;
    private int state;

}
