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
public class Comment implements Serializable {

    private static final long serialVersionUID = -7031768607524908823L;
    private Long id;
    private Long storyId;
    private Long spokesmanId;
    private Long listenerId;
    private String content;
    private Timestamp releaseDate;
    private Integer state;

}
