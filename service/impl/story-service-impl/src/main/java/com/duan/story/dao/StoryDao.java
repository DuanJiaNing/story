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

    List<Story> listStoryByIds(@Param("ids") List<Integer> ids, @Param("status") int status,
                               @Param("sortRule") SortRule sortRule);

    Integer findIdByWriterIdAndTitle(@Param("writerId") Integer writerId,
                                  @Param("title") String title);

    Story findStoryById(Integer id);

    Integer countByWriterIdAndState(@Param("writerId") Integer writerId,
                                    @Param("state") int state);

    List<Story> listStoryByWriterId(@Param("writerId") Integer writerId);

    List<Integer> listIdByWriterId(Integer writerId);
}
