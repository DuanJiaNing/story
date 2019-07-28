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
public class Profile implements Serializable {

	private static final long serialVersionUID = 9049979519978384798L;
    private Integer id;
	private Integer accountId;
	private String phone;
	private String email;
	private String aboutMe;
	private String motto;
	private String avatar;
	private Timestamp insertTime;
	private Timestamp updateTime;
}
