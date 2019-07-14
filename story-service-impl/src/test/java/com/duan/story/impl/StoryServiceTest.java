package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.StoryDTO;
import com.duan.story.common.enums.StoryStatusEnum;
import com.duan.story.service.StoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class StoryServiceTest extends T {

    @Autowired
    private StoryService test;

    @Test
    public void insertStory() {

        ResultModel r = test.insertStory(null, null, null);
        Assert.assertEquals(r.getCode(), 5000);

        StoryDTO s1 = new StoryDTO();
        s1.setState(StoryStatusEnum.PUBLIC.getCode());
        s1.setSummary("this is summary");
        s1.setTitle("Title");
        s1.setContent("this is content");
        s1.setReleaseDate(new Timestamp(new Date().getTime()));
        s1.setWriterId(T.account_duan_id);
        ResultModel rs1 = test.insertStory(s1, T.category_ids, T.label_ids);

    }

}
