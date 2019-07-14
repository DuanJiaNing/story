package com.duan.story.dao;

import com.duan.story.common.SortRule;
import com.duan.story.entity.Story;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/12/12.
 *
 * @author DuanJiaNing
 */
@Repository
public interface StoryDao extends BaseDao<Story> {

    List<Story> listStory();

    List<Story> listStoryByIds(@Param("ids") List<Long> ids, @Param("status") int status,
                               @Param("sortRule") SortRule sortRule);

    Long findIdByWriterIdAndTitle(@Param("writerId") Long writerId,
                                  @Param("title") String title);

    Story findStoryById(Long id);

    List<Story> listStoryByWriterId(Long writerId);

    Integer countByWriterIdAndState(@Param("writerId") Long writerId,
                                    @Param("state") int state);

    List<Story> listStoryByWriterIdAndFormat(@Param("writerId") Long writerId,
                                             @Param("format") int format);

    List<Long> listIdByWriterId(Long writerId);
}
