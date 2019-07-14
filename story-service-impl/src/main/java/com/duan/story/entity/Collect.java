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
public class Collect implements Serializable {

    private static final Long serialVersionUID = 2508868745231893082L;
    private Integer id;
    private Integer storyId;
    private Integer collectorId;
    private String reason;
    private Timestamp collectDate;

}
