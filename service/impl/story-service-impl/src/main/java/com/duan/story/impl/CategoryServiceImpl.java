package com.duan.story.impl;

import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.CategoryDTO;
import com.duan.story.dao.CategoryDao;
import com.duan.story.entity.Category;
import com.duan.story.service.CategoryService;
import com.duan.story.util.DataConverter;
import com.duan.story.util.ResultUtils;
import com.duan.story.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public ResultModel<CategoryDTO> insertCategory(CategoryDTO category) {
        if (category.getWriterId() == null || Utils.isStringBlank(category.getTitle())) {
            return ResultUtils.fail("");
        }

        Category cg = DataConverter.map(category, Category.class);
        if (categoryDao.insert(cg) <= 0) {
            return null;
        }

        return ResultUtils.success(DataConverter.map(cg, CategoryDTO.class));
    }

    @Override
    public ResultModel<PageResult<CategoryDTO>> listCategory(Integer writerId, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public boolean updateCategory(Integer writerId, Integer categoryId, Integer newIconId, String newTitle, String newBewrite) {
        return false;
    }

    @Override
    public boolean deleteCategoryAndMoveStoryTo(Integer writerId, Integer categoryId, Integer newCategoryId) {
        return false;
    }

    @Override
    public CategoryDTO getCategory(Integer writerId, Integer categoryId) {
        return null;
    }
}
