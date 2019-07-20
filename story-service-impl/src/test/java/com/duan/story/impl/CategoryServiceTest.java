package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.CategoryDTO;
import com.duan.story.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class CategoryServiceTest extends T {

    @Autowired
    private CategoryService test;

    @Test
    public void insertCategory() {

        CategoryDTO c1 = new CategoryDTO();
        c1.setWriterId(T.account_id.get(0));
        c1.setTitle("category1");
        c1.setBewrite("cate 1");
        ResultModel<CategoryDTO> r1 = test.insertCategory(c1);

        CategoryDTO c2 = new CategoryDTO();
        c2.setWriterId(T.account_id.get(0));
        c2.setTitle("category2");
        c2.setBewrite("cate 2");
        ResultModel<CategoryDTO> r2 = test.insertCategory(c2);

        CategoryDTO c3 = new CategoryDTO();
        c3.setWriterId(T.account_id.get(0));
        c3.setTitle("category3");
        c3.setBewrite("cate 3");
        ResultModel<CategoryDTO> r3 = test.insertCategory(c3);

    }

}
