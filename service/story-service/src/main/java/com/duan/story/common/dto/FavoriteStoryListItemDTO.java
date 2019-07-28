package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/18.
 *
 * @author DuanJiaNing
 */
@Data
public class FavoriteStoryListItemDTO implements Serializable {

    private static final Long serialVersionUID = -60440342784457887L;
    private Integer id;
    private Integer writerId;
    private StoryListItemDTO story;
    private String reason;
    private Timestamp date;

}
