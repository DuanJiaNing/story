package com.duan.story.dao;

import com.duan.story.entity.StoryCategoryRela;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2018/9/24.
 *
 * @author DuanJiaNing
 */
@Repository
public interface StoryCategoryRelaDao extends BaseDao<StoryCategoryRela> {

    List<StoryCategoryRela> listStoryCategoryRelaByStoryId(Integer storyId);

    int insertBatch(@Param("relas") List<StoryCategoryRela> relas);

    int deleteByStoryId(Integer storyId);
}
