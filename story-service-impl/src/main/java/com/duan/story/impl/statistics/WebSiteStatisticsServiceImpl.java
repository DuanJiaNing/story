package com.duan.story.impl.statistics;

import com.duan.story.common.dto.WriterBriefDTO;
import com.duan.story.common.dto.WriterDTO;
import com.duan.story.common.dto.WriterStatisticsDTO;
import com.duan.story.manager.WebsiteManager;
import com.duan.story.service.WriterService;
import com.duan.story.service.statistics.WebSiteStatisticsService;
import com.duan.story.service.statistics.WriterStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private WriterService writerService;

    @Autowired
    private WriterStatisticsService writerStatisticsService;

    @Override
    public List<WriterBriefDTO> listActiveWriter(int count) {
        List<WriterBriefDTO> rs = new ArrayList<>(count);

        List<Integer> ids = websiteManager.getActiveWriterIds(count);
        for (Integer id : ids) {
            WriterBriefDTO brief = new WriterBriefDTO();
            WriterDTO dto = writerService.getWriterDTO(id);
            brief.setWriter(dto);
            WriterStatisticsDTO s = writerStatisticsService.getWriterStatistics(id);
            brief.setStatistics(s);
            rs.add(brief);
        }

        return rs;
    }

}
