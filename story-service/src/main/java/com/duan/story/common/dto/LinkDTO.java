package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2017/12/15.
 *
 * @author DuanJiaNing
 */
@Data
public class LinkDTO implements Serializable {

    private static final long serialVersionUID = 5545136415441492665L;
    private Long id;
    private Long writerId;
    private String icon;
    private String title;
    private String url;
    private String bewrite;

}
