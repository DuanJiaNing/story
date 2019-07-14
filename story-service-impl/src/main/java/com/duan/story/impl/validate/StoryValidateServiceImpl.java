package com.duan.story.impl.validate;

import com.alibaba.dubbo.config.annotation.Service;
import com.duan.story.service.validate.StoryValidateService;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Service
public class StoryValidateServiceImpl implements StoryValidateService {

    @Override
    public boolean checkStoryExist(Long storyId) {
        return false;
    }

    @Override
    public boolean checkLabelsExist(Long labelId) {
        return false;
    }

    @Override
    public boolean isCreatorOfStory(Long writerId, Long storyId) {
        return false;
    }

    @Override
    public boolean verifyStory(String title, String content, String contentMd, String summary) {
        //TODO 博文内容校验
        return true;
    }

    @Override
    public boolean isStoryStatusAllow(int status) {
        return false;
    }

    @Override
    public boolean checkStoryStatisticExist(Long storyId) {
        return false;
    }
}

