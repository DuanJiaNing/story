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

    StoryStatistics findStoryStatisticsByStoryId(Long storyId);

    int updateCommentCount_plus(Long storyId);
    int updateViewCount_plus(Long storyId);
    int updateCollectCount_plus(Long storyId);
    int updateLikeCount_plus(Long storyId);
    int updateCommentCount_minus(Long storyId);
    int updateCollectCount_minus(Long storyId);
    int updateLikeCount_minus(Long storyId);

    Integer findViewCountByStoryId(Long storyId);
    Integer findLikeCountByStoryId(Long storyId);

}
