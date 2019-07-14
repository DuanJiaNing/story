package com.duan.story.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.StoryDTO;
import com.duan.story.common.dto.StoryImportTitleIdDTO;
import com.duan.story.common.enums.StoryExportFormatEnum;
import com.duan.story.common.vo.FileVO;
import com.duan.story.dao.StoryCategoryRelaDao;
import com.duan.story.dao.StoryDao;
import com.duan.story.dao.StoryLabelRelaDao;
import com.duan.story.dao.StoryStatisticsDao;
import com.duan.story.entity.Story;
import com.duan.story.entity.StoryCategoryRela;
import com.duan.story.entity.StoryLabelRela;
import com.duan.story.entity.StoryStatistics;
import com.duan.story.manager.StoryLuceneIndexManager;
import com.duan.story.manager.StoryManager;
import com.duan.story.service.StoryService;
import com.duan.story.util.DataConverter;
import com.duan.story.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Slf4j
@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryStatisticsDao statisticsDao;

    @Autowired
    private StoryManager storyManager;

    @Autowired
    private StoryCategoryRelaDao categoryRelaDao;

    @Autowired
    private StoryLabelRelaDao labelRelaDao;

    @Autowired
    private StoryDao storyDao;

    @Autowired
    private StoryLuceneIndexManager storyLuceneIndexManager;

    @Override
    public ResultModel<StoryDTO> insertStory(StoryDTO story, List<Long> categories, List<Long> labels) {
        if (story == null) {
            return ResultUtil.parameterRequireNoNull();
        }
        Story stortEntity = DataConverter.map(story, Story.class);

        // insert story
        // TODO story content validate
        int effect = storyDao.insert(stortEntity);
        if (effect <= 0) {
            return ResultUtil.fail();
        }

        // insert labels and categories
        Long storyId = story.getId();
        insertCategoryAndLabels(storyId, categories, labels);

        // insert data to story.story_statistics
        StoryStatistics statistics = new StoryStatistics();
        statistics.setStoryId(storyId);
        statistics.setWordCount(storyManager.calcContentLength(story.getContent()));
        effect = statisticsDao.insert(statistics);
        if (effect <= 0) {
            return ResultUtil.fail();
        }

        // create lucene index
        try {
            storyLuceneIndexManager.addIndex(stortEntity);
        } catch (IOException e) {
            log.error("got error when add lucene index", e);
            return ResultUtil.fail();
        }

        return ResultUtil.success(story);
    }

    private void insertCategoryAndLabels(Long storyId, List<Long> categories, List<Long> labels) {
        if (!CollectionUtils.isEmpty(categories)) {
            List<StoryCategoryRela> relas = new ArrayList<>();
            for (Long ca : categories) {
                StoryCategoryRela rela = new StoryCategoryRela();
                rela.setStoryId(storyId);
                rela.setCategoryId(ca);
                relas.add(rela);
            }

            categoryRelaDao.insertBatch(relas);
        }

        if (!CollectionUtils.isEmpty(labels)) {
            List<StoryLabelRela> relas = new ArrayList<>();
            for (Long ca : labels) {
                StoryLabelRela rela = new StoryLabelRela();
                rela.setStoryId(storyId);
                rela.setLabelId(ca);
                relas.add(rela);
            }

            labelRelaDao.insertBatch(relas);
        }
    }

    @Override
    public boolean updateStory(StoryDTO story, List<Long> categories, List<Long> labels) {
        return false;
    }

    @Override
    public boolean deleteStory(Long storyId) {
        return false;
    }

    @Override
    public boolean deleteStoryPatch(Long[] storyIds) {
        return false;
    }

    @Override
    public boolean getStoryForExistCheck(Long storyId) {
        return false;
    }

    @Override
    public ResultModel<StoryDTO> getStory(Long storyId) {
        return null;
    }

    @Override
    public Long getStoryId(Long writerId, String storyTitle) {
        return null;
    }

    @Override
    public List<StoryImportTitleIdDTO> insertStoryPatch(FileVO file, Long writerId) {
        return null;
    }

    @Override
    public String getAllStoryForDownload(Long writerId, StoryExportFormatEnum format) {
        return null;
    }
}
