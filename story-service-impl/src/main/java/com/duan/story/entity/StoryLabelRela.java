package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2018/9/24.
 *
 * @author DuanJiaNing
 */
@Data
public class StoryLabelRela implements Serializable {

    private static final long serialVersionUID = -163521546579338781L;
    private Long id;
    private Long storyId;
    private Long labelId;
    private Date insertTime;

}
