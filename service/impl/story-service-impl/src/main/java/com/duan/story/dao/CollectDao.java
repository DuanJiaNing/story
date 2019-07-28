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

    int deleteCollectByCollectorIdAndStoryId(@Param("collectorId") Integer collectorId, @Param("storyId") Integer storyId);

    List<Collect> listCollect(@Param("collectorId") Integer collectorId,
                              @Param("sortRule") SortRule sortRule);

    List<Collect> listCollectByStoryId(Integer storyId);

    Integer countByCollectorId(Integer collectorId);

    Collect findCollectByCollectorIdAndStoryId(@Param("collectorId") Integer collectorId, @Param("storyId") Integer storyId);

    List<Integer> listStoryIdByCollectorId(Integer collectorId);
}
