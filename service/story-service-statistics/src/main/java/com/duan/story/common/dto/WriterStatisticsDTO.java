package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2017/12/15.
 *
 * @author DuanJiaNing
 */
@Data
public class WriterStatisticsDTO implements Serializable {

    private static final Long serialVersionUID = 7911758004771633308L;
    private Integer storyCount;
    private Integer wordCount;
    private Integer likeCount;
    private Integer likedCount;
    private Integer categoryCount;
    private Integer labelCount;
    private Integer collectCount;
    private Integer collectedCount;
    private Integer linkCount;
}
