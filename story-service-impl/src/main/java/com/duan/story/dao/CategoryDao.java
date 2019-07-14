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

    List<Category> listCategoryByIds(@Param("ids") List<Integer> ids);

    List<Category> listCategoryByWriterId(Integer writerId);

    Category findCategoryById(Integer id);

    Integer countByWriterId(Integer writerId);

    Integer findIdByTitleAndWriterId(@Param("writerId") Integer writerId, @Param("title") String title);
}
