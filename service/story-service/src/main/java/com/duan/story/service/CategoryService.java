package com.duan.story.service;


import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.CategoryDTO;

/**
 * Created on 2017/12/18.
 *
 * @author DuanJiaNing
 */
public interface CategoryService {

    /**
     * 获取作者创建的类别，默认按时间倒序排序
     *
     * @param writerId id
     * @return 查询结果
     */
    ResultModel<PageResult<CategoryDTO>> listCategory(Integer writerId, Integer pageNum, Integer pageSize);

    /**
     * 修改类别
     *
     * @param writerId   id
     * @param categoryId 类别id
     * @param newIconId  新的类别图标，不修改传 -1
     * @param newTitle   新标题，不修改传 null
     * @param newBewrite 新描述，不修改传 null
     * @return 更新失败为false
     */
    boolean updateCategory(Integer writerId, Integer categoryId, Integer newIconId, String newTitle, String newBewrite);

    /**
     * 新增类别
     *
     * @return 新纪录id
     */
    ResultModel<CategoryDTO> insertCategory(CategoryDTO category);

    /**
     * 删除类别，同时移动类别下所有文章到新的类别中
     *
     * @param writerId      id
     * @param categoryId    要删除的类别
     * @param newCategoryId 新的类别（新类别创建者创建的类别），不修改传递-1
     */
    boolean deleteCategoryAndMoveStoryTo(Integer writerId, Integer categoryId, Integer newCategoryId);

    /**
     * 根据id获得指定类别
     *
     * @param writerId   id
     * @param categoryId 类别id
     * @return 查询结果
     */
    CategoryDTO getCategory(Integer writerId, Integer categoryId);
}
