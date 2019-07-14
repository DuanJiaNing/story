package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created on 2017/12/19.
 *
 * @author DuanJiaNing
 */
@Data
public class StoryStatisticsDTO implements Serializable {

    private static final Long serialVersionUID = -4213943192538419571L;
    private Integer id;
    private StoryBaseStatisticsDTO statistics;
    private List<CategoryDTO> categories;
    private List<LabelDTO> labels;
    private Integer state;
    private String title;
    private String summary;
    private Timestamp releaseDate;
    private Timestamp nearestModifyDate;
    private List<WriterDTO> likes;
    private List<WriterDTO> collects;
    private List<WriterDTO> commenter;

}
