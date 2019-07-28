package com.duan.story.service;


import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;
import com.duan.story.common.SortRule;
import com.duan.story.common.dto.StoryListItemDTO;
import com.duan.story.common.enums.StoryStatusEnum;

import java.util.List;

/**
 * Created on 2017/12/19.
 *
 * @author DuanJiaNing
 */
public interface StoryFilterService {

    /**
     * 全限定检索（包括关键字）
     *
     * @param categoryIds 限定在作者的哪些类别之下，不做限定时传null
     * @param labelIds    限定在作者的哪些标签之下，不做限定时传null
     * @param keyWord     关键字,不做限定时传null
     * @param writerId   id
     * @param sortRule    排序规则，为null则不做约束
     * @param status      状态
     * @return 查询结果
     */
    ResultModel<PageResult<StoryListItemDTO>> listFilter(List<Integer> categoryIds, List<Integer> labelIds, String keyWord,
                                                         Integer writerId,
                                                         Integer pageNum,
                                                         Integer pageSize,
                                                         SortRule sortRule,
                                                         StoryStatusEnum status);

    /**
     * 标签&类别检索（无关键字）
     *
     * @param labelIds    限定在作者的哪些标签之下
     * @param categoryIds 限定在作者的哪些类别之下
     * @param writerId    id
     * @param sortRule    排序规则，为null则不做约束
     * @param status      状态
     * @return 查询结果
     */
    ResultModel<PageResult<StoryListItemDTO>> listFilter(List<Integer> categoryIds, List<Integer> labelIds, Integer writerId,
                                                         Integer pageNum,
                                                         Integer pageSize,
                                                         SortRule sortRule,
                                                         StoryStatusEnum status);

}
