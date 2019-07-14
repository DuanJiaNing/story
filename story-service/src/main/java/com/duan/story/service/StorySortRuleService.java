package com.duan.story.service;


import com.duan.story.common.dto.StorySortRuleDTO;
import com.duan.story.common.ResultModel;

import java.util.List;

/**
 * Created on 2018/2/12.
 *
 * @author DuanJiaNing
 */
public interface StorySortRuleService {

    /**
     * 获得所有的排序规则
     *
     * @return 结果
     */
    ResultModel<List<StorySortRuleDTO>> listSortRule();

    /**
     * 获得排序顺序
     *
     * @return 结果
     */
    ResultModel<List<StorySortRuleDTO>> listSortOrder();

}
