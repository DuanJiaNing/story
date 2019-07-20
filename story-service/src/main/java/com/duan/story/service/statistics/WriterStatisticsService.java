package com.duan.story.service.statistics;


import com.duan.story.common.dto.WriterStatisticsDTO;

/**
 * Created on 2018/1/17.
 *
 * @author DuanJiaNing
 */
public interface WriterStatisticsService {

    /**
     * 获取作者统计信息
     *
     * @param writerId id
     * @return 查询结果
     */
    WriterStatisticsDTO getWriterStatistics(Integer writerId);

}
