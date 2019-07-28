package com.duan.story.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2018/10/1.
 *
 * @author DuanJiaNing
 */
@Data
public class SignInVO implements Serializable {

    private static final Long serialVersionUID = 8732436864285128268L;
    private String username;
    private String password;

}
