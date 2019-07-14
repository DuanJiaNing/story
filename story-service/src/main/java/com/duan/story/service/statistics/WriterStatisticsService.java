package com.duan.story.service.statistics;


import com.duan.story.common.dto.WriterDTO;
import com.duan.story.common.dto.WriterStatisticsDTO;
import com.duan.story.common.ResultModel;

import java.util.List;

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
    ResultModel<WriterStatisticsDTO> getWriterStatistics(Long writerId);

    /**
     * 根据 id 获取作者的 dto 对象
     *
     * @param ids id
     * @return 数组
     */
    List<WriterDTO> listWriter(List<Long> ids);

}
