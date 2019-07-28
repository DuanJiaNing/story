package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created on 2019/07/28.
 *
 * @author DuanJiaNing
 */
@Data
public class Account implements Serializable {

	private Integer id;
	private String username;
	private String password;
	private Timestamp insertTime;
	private Timestamp updateTime;
}
