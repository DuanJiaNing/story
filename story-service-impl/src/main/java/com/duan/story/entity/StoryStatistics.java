package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/14.
 *
 * @author DuanJiaNing
 */
@Data
public class StoryStatistics implements Serializable {

    private static final long serialVersionUID = 4777220255514776366L;
    private Long id;
    private Long storyId;
    private Integer commentCount;
    private Integer viewCount;
    private Integer replyCommentCount;
    private Integer collectCount;
    private Integer likeCount;
    private Integer wordCount;
    private Timestamp releaseDate;

}
