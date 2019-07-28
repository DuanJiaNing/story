package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2019/07/28.
 *
 * @author DuanJiaNing
 */
@Data
public class Setting implements Serializable {

    private static final long serialVersionUID = -3746517619619896274L;
    private Integer id;
    private Integer accountId;
    private Timestamp insertTime;
    private Timestamp updateTime;
}
