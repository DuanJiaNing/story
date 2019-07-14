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

    private static final long serialVersionUID = -6606102132213390615L;
    private Long id;
    private Long writerId;
    private Long iconId;
    private String title;
    private String url;
    private String bewrite;

}
