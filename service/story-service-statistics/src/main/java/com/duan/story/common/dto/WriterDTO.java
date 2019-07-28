package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2017/12/14.
 *
 * @author DuanJiaNing
 */
@Data
public class WriterDTO implements Serializable {

    private static final long serialVersionUID = -4572018061118612841L;
    private Integer id;
    private ProfileDTO profile;
    private AccountDTO account;

}
