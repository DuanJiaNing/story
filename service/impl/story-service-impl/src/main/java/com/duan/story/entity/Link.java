package com.duan.story.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2017/12/12.
 *
 * @author DuanJiaNing
 */
@Data
public class Link implements Serializable {

    private static final Long serialVersionUID = -6606102132213390615L;
    private Integer id;
    private Integer writerId;
    private Integer iconId;
    private String title;
    private String url;
    private String bewrite;

}
