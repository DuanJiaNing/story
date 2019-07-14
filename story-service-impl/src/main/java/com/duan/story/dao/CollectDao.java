package com.duan.story.dao;

import com.duan.story.common.SortRule;
import com.duan.story.entity.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/12/27.
 *
 * @author DuanJiaNing
 */
@Repository
public interface CollectDao extends BaseDao<Collect> {

    int deleteCollectByCollectorIdAndStoryId(@Param("collectorId") Long collectorId, @Param("storyId") Long storyId);

    List<Collect> listCollect(@Param("collectorId") Long collectorId,
                              @Param("sortRule") SortRule sortRule);

    List<Collect> listCollectByStoryId(Long storyId);

    Integer countByCollectorId(Long collectorId);

    Collect findCollectByCollectorIdAndStoryId(@Param("collectorId") Long collectorId, @Param("storyId") Long storyId);

    List<Long> listStoryIdByCollectorId(Long collectorId);
}
