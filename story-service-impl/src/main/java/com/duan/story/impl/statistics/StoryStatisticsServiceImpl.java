package com.duan.story.impl.statistics;

import com.alibaba.dubbo.config.annotation.Service;
import com.duan.story.common.Mode;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.*;
import com.duan.story.dao.*;
import com.duan.story.entity.*;
import com.duan.story.service.WriterService;
import com.duan.story.service.statistics.StoryStatisticsService;
import com.duan.story.util.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2017/12/19.
 *
 * @author DuanJiaNing
 */
@Service
public class StoryStatisticsServiceImpl implements StoryStatisticsService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private StoryDao storyDao;

    @Autowired
    private StoryStatisticsDao statisticsDao;

    @Autowired
    private LikeDao likeDao;

    @Autowired
    private CollectDao collectDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private StoryCategoryRelaDao categoryRelaDao;

    @Autowired
    private StoryLabelRelaDao labelRelaDao;

    @Autowired
    private WriterService writerService;

    @Override
    public ResultModel<StoryStatisticsDTO> getStoryStatistics(Long storyId) {
        Story story = storyDao.findStoryById(storyId);
        if (story == null) {
            return ResultModel.null_(Mode.STORY);
        }
        StoryStatisticsDTO ss = DataConverter.map(story, StoryStatisticsDTO.class);

        // 统计信息
        StoryStatistics statistics = statisticsDao.findStoryStatisticsByStoryId(storyId);
        if (statistics == null) {
            return ResultModel.null_(Mode.STORY_STATISTICS);
        }
        ss.setStatistics(DataConverter.map(statistics, StoryBaseStatisticsDTO.class));

        // 喜欢该篇文章的人
        List<Like> likeList = likeDao.listLikeByStoryId(storyId);
        if (!CollectionUtils.isEmpty(likeList)) {
            List<Long> ids = likeList.stream()
                    .map(Like::getLikerId)
                    .collect(Collectors.toList());
            List<WriterDTO> likes = writerService.listWriter(ids);
            ss.setLikes(likes);
        }

        // 收藏了该篇文章的人
        List<Collect> collectList = collectDao.listCollectByStoryId(storyId);
        if (!CollectionUtils.isEmpty(collectList)) {
            List<Long> ids = collectList.stream()
                    .map(Collect::getCollectorId)
                    .collect(Collectors.toList());
            List<WriterDTO> collects = writerService.listWriter(ids);
            ss.setCollects(collects);
        }

        // 评论过该篇文章的人
        List<Comment> commentList = commentDao.listCommentByStoryId(storyId);
        if (!CollectionUtils.isEmpty(commentList)) {
            List<Long> ls = commentList.stream()
                    .map(Comment::getSpokesmanId)
                    .collect(Collectors.toList());
            List<WriterDTO> commenter = writerService.listWriter(ls);
            ss.setCommenter(commenter);
        }

        // 类别
        List<StoryCategoryRela> relas = categoryRelaDao.listStoryCategoryRelaByStoryId(storyId);
        if (!CollectionUtils.isEmpty(relas)) {
            List<Long> cids = relas.stream()
                    .map(StoryCategoryRela::getCategoryId)
                    .collect(Collectors.toList());
            List<Category> categories = categoryDao.listCategoryByIds(cids);
            List<CategoryDTO> cc = new ArrayList<>(categories.size());
            categories.forEach(cate -> cc.add(DataConverter.map(cate, CategoryDTO.class)));
            ss.setCategories(cc);
        }

        // 标签
        List<StoryLabelRela> lrelas = labelRelaDao.listStoryLabelRelaByStoryId(storyId);
        if (!CollectionUtils.isEmpty(lrelas)) {
            List<Long> lids = lrelas.stream()
                    .map(StoryLabelRela::getLabelId)
                    .collect(Collectors.toList());
            List<Label> labels = labelDao.listLabelByIds(lids);
            List<LabelDTO> ll = new ArrayList<>(labels.size());
            labels.forEach(l -> ll.add(DataConverter.map(l, LabelDTO.class)));
            ss.setLabels(ll);
        }

        return ResultModel.success(ss);
    }

    @Override
    public ResultModel<StoryBaseStatisticsDTO> getStoryStatisticsCount(Long storyId) {
        return ResultModel.fail();
    }

}
