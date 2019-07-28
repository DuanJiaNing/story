package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2018/4/4.
 *
 * @author DuanJiaNing
 */
@Data
public class StoryImportTitleIdDTO implements Serializable {

    private static final Long serialVersionUID = -5877719215260338615L;
    private String title;
    private Integer id;
}
