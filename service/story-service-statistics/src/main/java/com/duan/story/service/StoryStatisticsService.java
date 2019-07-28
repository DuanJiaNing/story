package com.duan.story.service;


import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.StoryBaseStatisticsDTO;
import com.duan.story.common.dto.StoryStatisticsDTO;

/**
 * Created on 2017/12/18.
 *
 * @author DuanJiaNing
 */
public interface StoryStatisticsService {

    /**
     * 获取故事统计信息
     *
     * @param storyId id
     * @return 查询结果
     */
    ResultModel<StoryStatisticsDTO> getStoryStatistics(Integer storyId);

    /**
     * 获取故事统计信息（只获取数据量）
     *
     * @param storyId id
     * @return 查询结果
     */
    ResultModel<StoryBaseStatisticsDTO> getStoryStatisticsCount(Integer storyId);

}

