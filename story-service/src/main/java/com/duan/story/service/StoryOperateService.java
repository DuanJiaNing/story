package com.duan.story.service;

/**
 * Created on 2017/12/26.
 *
 * @author DuanJiaNing
 */
public interface StoryOperateService {


    /**
     * 新增收藏记录，同时收藏次数加一
     *
     * @param storyId     id
     * @param collectorId 收藏者id
     * @param reason      收藏理由
     * @param categoryId  收藏到收藏者自己的哪一个类别
     * @return 新纪录id
     */
    Long insertCollect(Long storyId, Long collectorId, String reason, Long categoryId);

    /**
     * 取消收藏，同时收藏数减一
     *
     * @param writerId 收藏者id
     * @param storyId  id
     * @return 删除成功返回true
     */
    boolean deleteCollect(Long writerId, Long storyId);

    /**
     * 新增喜欢记录，同时喜欢数加一
     *
     * @param storyId id
     * @param likerId 给出喜欢的人的id
     * @return 喜欢数
     */
    Integer insertLike(Long storyId, Long likerId);

    /**
     * 取消喜欢，同时喜欢数减一
     *
     * @param likerId 喜欢者id
     * @param storyId id
     * @return 删除成功返回true
     */
    boolean deleteLike(Long likerId, Long storyId);

    /**
     * 浏览次数加一
     *
     * @param storyId id
     */
    void updateViewCountPlus(Long storyId);
}
