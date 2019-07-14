package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2018/10/1.
 *
 * @author DuanJiaNing
 */
@Data
public class LoginResultDTO implements Serializable {

    private static final Long serialVersionUID = 8778909310699470335L;
    private Integer id;
    private String username;
    private String usernameBase64;
    private String token;
    private Timestamp registerDate;
}
