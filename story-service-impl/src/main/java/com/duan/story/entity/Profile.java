package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2017/12/12.
 *
 * @author DuanJiaNing
 */
@Data
public class Profile implements Serializable {

    private static final long serialVersionUID = -1116962500544770692L;
    private Long id;
    private Long writerId;
    private String avatar;
    private String phone;
    private String email;
    private String aboutMe;
    private String intro;

}
