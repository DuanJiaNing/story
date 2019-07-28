package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.dto.WriterBriefDTO;
import com.duan.story.service.statistics.WebSiteStatisticsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created on 2019/7/19.
 *
 * @author DuanJiaNing
 */
public class WebSiteStatisticsServiceTest extends T {

    @Autowired
    private WebSiteStatisticsService test;

    @Test
    public void listActiveWriter() {
        List<WriterBriefDTO> dtos = test.listActiveWriter(8);
        outJson(dtos);
    }
}
