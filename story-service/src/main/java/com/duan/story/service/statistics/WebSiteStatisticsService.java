package com.duan.story.service.statistics;


import com.duan.story.common.dto.WriterBriefDTO;

import java.util.List;

/**
 * Created on 2018/5/1.
 *
 * @author DuanJiaNing
 */
public interface WebSiteStatisticsService {

    /**
     * 获取活跃作者
     *
     * @param count 数量
     * @return 集合
     */
    List<WriterBriefDTO> listActiveWriter(int count);

}
