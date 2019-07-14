package com.duan.story.dao;

import com.duan.story.common.SortRule;
import com.duan.story.entity.Like;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/12/27.
 *
 * @author DuanJiaNing
 */
@Repository
public interface LikeDao extends BaseDao<Like> {

    int deleteLikeByLikerIdAndStoryId(@Param("likerId") Integer likerId, @Param("storyId") Integer storyId);

    List<Like> listLikeByStoryId(Integer storyId);

    Integer countLikeByLikerId(Integer likerId);

    Like findLikeByLikerIdAndStoryId(@Param("likerId") Integer likerId, @Param("storyId") Integer storyId);

    List<Like> listLikeByLikerId(@Param("likerId") Integer likerId, @Param("sortRule") SortRule sortRule);

}
