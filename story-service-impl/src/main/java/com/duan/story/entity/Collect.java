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

    private static final long serialVersionUID = 2508868745231893082L;
    private Long id;
    private Long storyId;
    private Long collectorId;
    private String reason;
    private Timestamp collectDate;

}
