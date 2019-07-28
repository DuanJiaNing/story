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
public class Role implements Serializable {

    private static final long serialVersionUID = 4480551960098539692L;
    private Integer id;
    private Integer accountId;
    private String role;
    private String intro;
    private Timestamp insertTime;
    private Timestamp updateTime;
}
