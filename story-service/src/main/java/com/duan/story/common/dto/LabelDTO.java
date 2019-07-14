package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
@Data
public class LabelDTO implements Serializable {

    private static final Long serialVersionUID = 5177571584390818652L;
    private Integer id;
    private Integer writerId;
    private String title;
    private Timestamp createDate;
}
