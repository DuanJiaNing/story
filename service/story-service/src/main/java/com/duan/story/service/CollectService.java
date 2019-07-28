package com.duan.story.service;


import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;
import com.duan.story.common.SortRule;
import com.duan.story.common.dto.FavoriteStoryListItemDTO;

/**
 * Created on 2017/12/18.
 *
 * @author DuanJiaNing
 */
public interface CollectService {


    /**
     * 获得作者收藏的故事清单
     *
     * @param writerId id
     * @param sortRule 排序规则，为null则不做约束
     * @return 查询结果
     */
    ResultModel<PageResult<FavoriteStoryListItemDTO>> listCollect(Integer writerId, Integer pageNum, Integer pageSize,
                                                                  SortRule sortRule);

    /**
     * 更新收藏信息
     *
     * @param writerId  id
     * @param storyId   id
     * @param newReason 新的收藏理由
     * @return 更新成功返回true
     */
    boolean updateCollect(Integer writerId, Integer storyId, String newReason);

    /**
     * 获得收藏状态
     *
     * @param writerId id
     * @param storyId  id
     * @return 已收藏为 true
     */
    boolean getCollectState(Integer writerId, Integer storyId);

    /**
     * 统计指定作者的故事收藏数
     *
     * @param writerId id
     * @return 查询结果
     */
    int countWriterCollectNum(Integer writerId);
}
