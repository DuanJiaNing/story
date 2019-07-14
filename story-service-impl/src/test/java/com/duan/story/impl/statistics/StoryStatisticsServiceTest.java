package com.duan.story.impl.statistics;

import com.duan.story.TestApplication;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.StoryStatisticsDTO;
import com.duan.story.service.statistics.StoryStatisticsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */

public class StoryStatisticsServiceTest extends TestApplication {

    @Autowired
    private StoryStatisticsService test;

    @Test
    public void getStoryStatistics() {
        ResultModel<StoryStatisticsDTO> s = test.getStoryStatistics(1L);
        out(s);
    }
}
