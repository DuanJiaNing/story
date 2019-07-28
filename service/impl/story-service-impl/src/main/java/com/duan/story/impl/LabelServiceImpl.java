package com.duan.story.impl;

import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.LabelDTO;
import com.duan.story.dao.LabelDao;
import com.duan.story.entity.Label;
import com.duan.story.service.LabelService;
import com.duan.story.util.ResultUtil;
import com.duan.story.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    @Override
    public ResultModel<LabelDTO> insertLabel(LabelDTO label) {
        if (label.getWriterId() == null || Util.isStringBlank(label.getTitle())) {
            return ResultUtil.fail(5002);
        }

        Label la = DataConverter.map(label, Label.class);
        if (labelDao.insert(la) <= 0) {
            return null;
        }

        return ResultUtil.success(DataConverter.map(label, LabelDTO.class));
    }

    @Override
    public boolean updateLabel(Integer labelId, Integer writerId, String newTitle) {
        return false;
    }

    @Override
    public boolean deleteLabel(Integer writerId, Integer labelId) {
        return false;
    }

    @Override
    public ResultModel<PageResult<LabelDTO>> listLabel(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public LabelDTO getLabel(Integer labelId) {
        return null;
    }

    @Override
    public ResultModel<PageResult<LabelDTO>> listWritersLabel(Integer writerId, Integer pageNum, Integer pageSize) {
        return null;
    }
}
