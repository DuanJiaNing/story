package com.duan.story.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2019/7/28.
 *
 * @author DuanJiaNing
 */
@Data
public class SignUpVO implements Serializable {

    private static final long serialVersionUID = 98283281501628728L;
    private String username;
    private String password;
    private String email;
    private String homePageTitle;
    private String aboutMe;

}
