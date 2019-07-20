package com.duan.story.dao;

import com.duan.story.entity.StoryStatistics;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/12/20.
 *
 * @author DuanJiaNing
 */
@Repository
public interface StoryStatisticsDao extends BaseDao<StoryStatistics> {

    StoryStatistics findStoryStatisticsByStoryId(Integer storyId);

    int updateCommentCount_plus(Integer storyId);
    int updateViewCount_plus(Integer storyId);
    int updateCollectCount_plus(Integer storyId);
    int updateLikeCount_plus(Integer storyId);
    int updateCommentCount_minus(Integer storyId);
    int updateCollectCount_minus(Integer storyId);
    int updateLikeCount_minus(Integer storyId);

    Integer findViewCountByStoryId(Integer storyId);
    Integer findLikeCountByStoryId(Integer storyId);

    List<StoryStatistics> listByWriterId(Integer writerId);
}
