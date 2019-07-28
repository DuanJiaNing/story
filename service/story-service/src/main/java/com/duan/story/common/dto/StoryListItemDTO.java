package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/16.
 *
 * @author DuanJiaNing
 */
@Data
public class StoryListItemDTO implements Serializable {

    private static final Long serialVersionUID = -5072404723143229440L;
    private Integer id;
    private CategoryDTO[] categories;
    private LabelDTO[] labels;
    private Integer state;
    private String title;
    private String titleBase64;
    private String summary;
    private String img;
    private Timestamp releaseDate;
    private Timestamp nearestModifyDate;
    private StoryBaseStatisticsDTO statistics;

}
