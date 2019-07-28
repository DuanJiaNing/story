package com.duan.story.dao;

import com.duan.story.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/12/25.
 *
 * @author DuanJiaNing
 */
@Repository
public interface CommentDao extends BaseDao<Comment> {

    List<Comment> listCommentByStoryIdAndState(@Param("storyId") Integer storyId,
                                               @Param("status") int status);

    List<Comment> listCommentByStoryId(Integer storyId);

    Comment findCommentById(Integer id);

}
