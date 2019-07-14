package com.duan.story.service;

import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.StoryDTO;
import com.duan.story.common.dto.StoryImportTitleIdDTO;
import com.duan.story.common.enums.StoryExportFormatEnum;
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
     * @param categories 类别
     * @param labels     标签
     * @return 新纪录id
     */
    ResultModel insertStory(StoryDTO story, List<Long> categories, List<Long> labels);

    /**
     * 1 更新故事
     * 2 更新lucene
     *
     * @return 更新失败为false
     */
    boolean updateStory(StoryDTO story, List<Long> categories, List<Long> labels);

    /**
     * 1 删除故事
     * 2 删除统计信息记录
     * 3 删除lucene索引
     *
     * @param storyId  id
     * @return 删除的记录
     */
    boolean deleteStory(Long storyId);

    /**
     * 批量删除故事
     *
     * @param storyIds id
     * @return 操作失败为false
     */
    boolean deleteStoryPatch(Long[] storyIds);

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
