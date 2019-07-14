package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/25.
 *
 * @author DuanJiaNing
 */
@Data
public class StoryBaseStatisticsDTO implements Serializable {

    private static final long serialVersionUID = 8922651148402857438L;
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
