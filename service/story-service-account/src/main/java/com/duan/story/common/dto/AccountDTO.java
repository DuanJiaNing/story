package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
@Data
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = -9194349597414671316L;
    private Integer id;
    private String username;
    private String password;
    private String token;
    private Timestamp registerDate;

}
