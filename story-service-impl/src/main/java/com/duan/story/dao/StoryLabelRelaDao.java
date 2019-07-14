package com.duan.story.dao;

import com.duan.story.entity.StoryLabelRela;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2018/9/24.
 *
 * @author DuanJiaNing
 */
@Repository
public interface StoryLabelRelaDao extends BaseDao<StoryLabelRela> {

    List<StoryLabelRela> listStoryLabelRelaByStoryId(Long storyId);

    int insertBatch(@Param("relas") List<StoryLabelRela> relas);

    int deleteByStoryId(Long storyId);

}
