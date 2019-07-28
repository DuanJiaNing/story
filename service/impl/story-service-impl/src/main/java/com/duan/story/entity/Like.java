package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/26.
 *
 * @author DuanJiaNing
 */
@Data
public class Like implements Serializable {

    private static final Long serialVersionUID = 7850020610771820655L;
    private Integer id;
    private Integer storyId;
    private Integer likerId;
    private Timestamp likeDate;

}
