package com.duan.story.impl.statistics;

import com.duan.story.common.dto.WriterBriefDTO;
import com.duan.story.manager.WebsiteManager;
import com.duan.story.service.statistics.WebSiteStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/7/17.
 *
 * @author DuanJiaNing
 */
@Service
public class WebSiteStatisticsServiceImpl implements WebSiteStatisticsService {

    @Autowired
    private WebsiteManager websiteManager;

    @Override
    public List<WriterBriefDTO> listActiveWriter(int count) {

        List<Integer> ids = websiteManager.getActiveWriterIds(count);

        return null;
    }

}
