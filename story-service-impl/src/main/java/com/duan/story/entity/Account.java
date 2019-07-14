package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2017/12/12.
 *
 * @author DuanJiaNing
 */
@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 2687551997656155242L;
    private Integer id;
    private String username;
    private String password;
    private Timestamp registerDate;

}
