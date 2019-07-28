package com.duan.story.impl;

import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.StoryDTO;
import com.duan.story.common.dto.StoryImportTitleIdDTO;
import com.duan.story.common.enums.StoryExportFormatEnum;
import com.duan.story.common.enums.StoryStatusEnum;
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
import org.springframework.stereotype.Service;
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
    public ResultModel<StoryDTO> insertStory(StoryDTO story, List<Integer> categories, List<Integer> labels) {
        if (story == null) {
            log.error("story can not be null");
            return ResultUtil.fail(5000);
        }

        if (story.getState() == null || StoryStatusEnum.valueOf(story.getState()) == null) {
            return ResultUtil.fail(5002);
        }

        Story stortEntity = DataConverter.map(story, Story.class);

        // insert story
        // TODO story content validate
        if (storyDao.insert(stortEntity) <= 0) {
            log.error("got error when insert story");
            return ResultUtil.fail(5001);
        }

        // insert labels and categories
        Integer storyId = stortEntity.getId();
        insertCategoryAndLabels(storyId, categories, labels);

        // insert data to story statistics
        StoryStatistics statistics = new StoryStatistics();
        statistics.setCommentCount(0);
        statistics.setViewCount(0);
        statistics.setReplyCommentCount(0);
        statistics.setCollectCount(0);
        statistics.setLikeCount(0);
        statistics.setStoryId(storyId);
        statistics.setWordCount(storyManager.calcContentLength(stortEntity.getContent()));
        if (statisticsDao.insert(statistics) <= 0) {
            log.error("got error when insert story statistics");
            return ResultUtil.fail(5001);
        }

        // create lucene index
        try {
            storyLuceneIndexManager.addIndex(stortEntity);
        } catch (IOException e) {
            log.error("got error when add lucene index", e);
            return ResultUtil.fail(5001);
        }

        return ResultUtil.success(story);
    }

    private void insertCategoryAndLabels(Integer storyId, List<Integer> categories, List<Integer> labels) {
        if (!CollectionUtils.isEmpty(categories)) {
            List<StoryCategoryRela> relas = new ArrayList<>();
            for (Integer ca : categories) {
                StoryCategoryRela rela = new StoryCategoryRela();
                rela.setStoryId(storyId);
                rela.setCategoryId(ca);
                relas.add(rela);
            }

            categoryRelaDao.insertBatch(relas);
        }

        if (!CollectionUtils.isEmpty(labels)) {
            List<StoryLabelRela> relas = new ArrayList<>();
            for (Integer ca : labels) {
                StoryLabelRela rela = new StoryLabelRela();
                rela.setStoryId(storyId);
                rela.setLabelId(ca);
                relas.add(rela);
            }

            labelRelaDao.insertBatch(relas);
        }
    }

    @Override
    public boolean updateStory(StoryDTO story, List<Integer> categories, List<Integer> labels) {
        return false;
    }

    @Override
    public boolean deleteStory(Integer storyId) {
        return false;
    }

    @Override
    public boolean deleteStoryPatch(Integer[] storyIds) {
        return false;
    }

    @Override
    public boolean getStoryForExistCheck(Integer storyId) {
        return false;
    }

    @Override
    public ResultModel<StoryDTO> getStory(Integer storyId) {
        return null;
    }

    @Override
    public Integer getStoryId(Integer writerId, String storyTitle) {
        return null;
    }

    @Override
    public List<StoryImportTitleIdDTO> insertStoryPatch(FileVO file, Integer writerId) {
        return null;
    }

    @Override
    public String getAllStoryForDownload(Integer writerId, StoryExportFormatEnum format) {
        return null;
    }
}
