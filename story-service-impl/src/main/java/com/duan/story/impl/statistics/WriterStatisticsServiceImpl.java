package com.duan.story.impl.statistics;

import com.duan.story.common.dto.WriterStatisticsDTO;
import com.duan.story.common.enums.StoryStatusEnum;
import com.duan.story.dao.*;
import com.duan.story.entity.StoryStatistics;
import com.duan.story.service.statistics.WriterStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created on 2019/7/19.
 *
 * @author DuanJiaNing
 */
@Service
public class WriterStatisticsServiceImpl implements WriterStatisticsService {

    @Autowired
    private StoryDao storyDao;

    @Autowired
    private LikeDao likeDao;

    @Autowired
    private LinkDao linkDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private CollectDao collectDao;

    @Autowired
    private StoryStatisticsDao storyStatisticsDao;

    @Override
    public WriterStatisticsDTO getWriterStatistics(Integer writerId) {

        List<StoryStatistics> statistics = storyStatisticsDao.listByWriterId(writerId);
        if (CollectionUtils.isEmpty(statistics)) {
            return null;
        }

        int wordCount = statistics.stream().mapToInt(StoryStatistics::getWordCount).sum();
        int likeCount = statistics.stream().mapToInt(StoryStatistics::getLikeCount).sum();
        int collectedCount = statistics.stream().mapToInt(StoryStatistics::getCollectCount).sum();

        int storyCount = storyDao.countByWriterIdAndState(writerId, StoryStatusEnum.PUBLIC.getCode());
        int likedCount = likeDao.countLikeByLikerId(writerId);
        int categoryCount = categoryDao.countByWriterId(writerId);
        int labelCount = labelDao.countByWriterId(writerId);
        int collectCount = collectDao.countByCollectorId(writerId);
        int linkCount = linkDao.countLinkByWriterId(writerId);

        WriterStatisticsDTO dto = new WriterStatisticsDTO();
        dto.setStoryCount(storyCount);
        dto.setWordCount(wordCount);
        dto.setLikeCount(likeCount);
        dto.setLikedCount(likedCount);
        dto.setCategoryCount(categoryCount);
        dto.setLabelCount(labelCount);
        dto.setCollectCount(collectCount);
        dto.setCollectedCount(collectedCount);
        dto.setLinkCount(linkCount);

        return dto;
    }

}
