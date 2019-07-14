package com.duan.story.service;

import com.duan.story.common.dto.StoryDTO;
import com.duan.story.common.dto.StoryImportTitleIdDTO;
import com.duan.story.common.enums.StoryExportFormatEnum;
import com.duan.story.common.enums.StoryStatusEnum;
import com.duan.story.common.ResultModel;
import com.duan.story.common.vo.FileVO;

import java.util.List;

/**
 * Created on 2017/12/18.
 *
 * @author DuanJiaNing
 */
public interface StoryService {

    /**
     * 1 新增故事
     * 2 为故事生成一条统计信息记录
     * 3 lucene添加索引
     *
     * @param writerId   id
     * @param categories 类别
     * @param labels     标签
     * @param status     状态
     * @param title      标题
     * @param content    内容
     * @param contentMd  md内容
     * @param summary    摘要
     * @return 新纪录id
     */
    Long insertStory(Long writerId, Long[] categories, Long[] labels, StoryStatusEnum status, String title,
                     String content,
                     String contentMd,
                     String summary);

    /**
     * 1 更新故事
     * 2 更新lucene
     *
     * @param writerId      id
     * @param storyId       id
     * @param newCategories 新类别，不修改传null
     * @param newLabels     新标签，不修改传null
     * @param newStatus     新状态，不修改传null
     * @param newTitle      新标题，不修改传null
     * @param newContent    新内容，不修改传null
     * @param newContentMd  md内容，不修改传null
     * @param newSummary    新摘要，不修改传null
     * @return 更新失败为false
     */
    boolean updateStory(Long writerId, Long storyId, Long[] newCategories, Long[] newLabels, StoryStatusEnum newStatus,
                        String newTitle,
                        String newContent,
                        String newContentMd,
                        String newSummary);

    /**
     * 1 删除故事
     * 2 删除统计信息记录
     * 3 删除lucene索引
     *
     * @param writerId id
     * @param storyId  id
     * @return 删除的记录
     */
    boolean deleteStory(Long writerId, Long storyId);

    /**
     * 批量删除故事
     *
     * @param writerId id
     * @param storyIds id
     * @return 操作失败为false
     */
    boolean deleteStoryPatch(Long writerId, Long[] storyIds);

    /**
     * 检查故事是否存在
     *
     * @param storyId id
     * @return 存在返回true，否则false
     */
    boolean getStoryForExistCheck(Long storyId);

    /**
     * 获得故事
     *
     * @param storyId id
     * @return 查询结果
     */
    ResultModel<StoryDTO> getStory(Long storyId);

    /**
     * 获得故事id
     *
     * @param writerId   id
     * @param storyTitle 标题
     * @return 存在返回id，否则-1
     */
    Long getStoryId(Long writerId, String storyTitle);

    /**
     * 通过上传的 zip 文件批量导入故事
     *
     * @param file     文件
     * @param writerId id
     * @return 成功导入的故事标题和id
     */
    List<StoryImportTitleIdDTO> insertStoryPatch(FileVO file, Long writerId);

    /**
     * 生成用于 [导出所有故事] 功能的 zip 文件
     *
     * @param writerId id
     * @param format   格式
     * @return zip 文件全路径
     */
    String getAllStoryForDownload(Long writerId, StoryExportFormatEnum format);
}
