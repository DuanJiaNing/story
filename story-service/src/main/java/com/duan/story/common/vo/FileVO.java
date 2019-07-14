package com.duan.story.common.vo;

import lombok.Data;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Created on 2018/10/6.
 *
 * @author DuanJiaNing
 */
@Data
public class FileVO implements Serializable {

    private static final Long serialVersionUID = -5629820867784201367L;
    private InputStream inputStream;
    private String originalFilename;
    private String contentType;

}
