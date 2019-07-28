package com.duan.story.service;


import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;
import com.duan.story.common.SortRule;
import com.duan.story.common.dto.FavoriteStoryListItemDTO;

/**
 * Created on 2018/3/11.
 *
 * @author DuanJiaNing
 */
public interface LikeService {

    /**
     * 检查作者是否喜欢过指定故事
     *
     * @param writerId id
     * @param storyId  id
     * @return 已喜欢返回 true
     */
    boolean liked(Integer writerId, Integer storyId);

    /**
     * 获取作者喜欢的故事列表
     *
     * @param writerId id
     * @param sortRule 排序规则
     * @return 查询结果
     */
    ResultModel<PageResult<FavoriteStoryListItemDTO>> listLike(Integer writerId, Integer pageNum, Integer pageSize,
                                                               SortRule sortRule);

    /**
     * 统计喜欢量
     *
     * @param writerId id
     * @return 查询结果
     */
    int countWriterLikeNum(Integer writerId);
}
