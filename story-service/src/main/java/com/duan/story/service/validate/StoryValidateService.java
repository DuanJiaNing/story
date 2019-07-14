package com.duan.story.service.validate;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
public interface StoryValidateService {

    /**
     * 检查故事是否存在
     *
     * @param storyId id
     * @return 存在返回true
     */
    boolean checkStoryExist(Integer storyId);

    /**
     * 检查标签是否存在
     *
     * @param labelId 标签id
     * @return 存在返回true
     */
    boolean checkLabelsExist(Integer labelId);

    /**
     * 检查作者是否为当前故事的创作者
     *
     * @param writerId id
     * @param storyId  id
     * @return 是返回true
     */
    boolean isCreatorOfStory(Integer writerId, Integer storyId);

    /**
     * 检验是否合法
     *
     * @param title    标题
     * @param content  内容
     * @param summary  摘要
     * @return 合法返回true
     */
    boolean verifyStory(String title, String content, String contentMd, String summary);

    /**
     * 检查目标状态是否允许，一般用户只允许在“公开”，“私有”，“回收站”之间切换。
     *
     * @param status 状态值
     * @return 允许返回true
     */
    boolean isStoryStatusAllow(int status);

    /**
     * 检查故事的统计信息是否存在
     *
     * @param storyId id
     * @return 存在返回true
     */
    boolean checkStoryStatisticExist(Integer storyId);

}
