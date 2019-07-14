package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
@Data
public class SettingDTO implements Serializable {

    private static final long serialVersionUID = 3960419989520032049L;
    private Long id;
    private Long writerId;

}
