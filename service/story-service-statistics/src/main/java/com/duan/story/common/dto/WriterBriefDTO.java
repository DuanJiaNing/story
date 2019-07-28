package com.duan.story.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2018/5/4.
 *
 * @author DuanJiaNing
 */
@Data
public class WriterBriefDTO implements Serializable {

    private static final Long serialVersionUID = 4587186975222933098L;
    private WriterStatisticsDTO statistics;
    private WriterDTO writer;
}
