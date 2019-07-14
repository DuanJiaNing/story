package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
@Data
public class ProfileDTO implements Serializable {

    private static final long serialVersionUID = 6674849351249573711L;
    private Long id;
    private Long writerId;
    private String avatar;
    private String phone;
    private String email;
    private String aboutMe;
    private String intro;

}
