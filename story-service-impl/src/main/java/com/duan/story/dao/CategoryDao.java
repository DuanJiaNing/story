package com.duan.story.dao;

import com.duan.story.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/12/20.
 *
 * @author DuanJiaNing
 */
@Repository
public interface CategoryDao extends BaseDao<Category> {

    List<Category> listCategoryByIds(@Param("ids") List<Long> ids);

    List<Category> listCategoryByWriterId(Long writerId);

    Category findCategoryById(Long id);

    Integer countByWriterId(Long writerId);

    Long findIdByTitleAndWriterId(@Param("writerId") Long writerId, @Param("title") String title);
}
