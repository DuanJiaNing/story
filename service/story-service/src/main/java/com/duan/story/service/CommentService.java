package com.duan.story.service;

import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.CommentDTO;

/**
 * Created on 2018/3/13.
 *
 * @author DuanJiaNing
 */
public interface CommentService {

    /**
     * 新增一条评论记录，同时故事评论次数加一
     *
     * @param storyId     id
     * @param spokesmanId 发言者
     * @param listenerId  被评论者
     * @param state       留言状态
     * @param content     评论内容
     * @return 新纪录id
     */
    Integer insertComment(Integer storyId, Integer spokesmanId, Integer listenerId, int state, String content);

    /**
     * 删除评论
     *
     * @param commentId   评论id
     * @param spokesmanId id
     * @return 删除成功返回true
     */
    boolean deleteComment(Integer commentId, Integer spokesmanId);

    /**
     * 获取评论 列表
     *
     * @param storyId  id
     * @param pageSize 分页大小
     * @param pageNum  页数量
     * @return 结果
     */
    ResultModel<PageResult<CommentDTO>> listStoryComment(Integer storyId, Integer pageSize, Integer pageNum);

}
