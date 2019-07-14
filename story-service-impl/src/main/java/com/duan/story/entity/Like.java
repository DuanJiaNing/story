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

    private static final long serialVersionUID = 7850020610771820655L;
    private Long id;
    private Long storyId;
    private Long likerId;
    private Timestamp likeDate;

}
