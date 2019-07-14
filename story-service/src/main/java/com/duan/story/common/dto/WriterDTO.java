package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/14.
 *
 * @author DuanJiaNing
 */
@Data
public class WriterDTO implements Serializable {

    private static final long serialVersionUID = -883473780563116771L;
    private Long id;
    private ProfileDTO profile;
    private String username;
    private Timestamp registerDate;

}
