package com.duan.story.service;


import com.duan.story.common.dto.LabelDTO;
import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;

/**
 * Created on 2017/12/18.
 *
 * @author DuanJiaNing
 */
public interface LabelService {

    /**
     * 新增标签
     *
     * @param writerId 标签创建者id
     * @param title    标签名
     * @return 新纪录id
     */
    Long insertLabel(Long writerId, String title);

    /**
     * 修改标签
     *
     * @param labelId  标签id
     * @param writerId 标签所有者
     * @param newTitle 新标签名
     * @return 更新失败为false
     */
    boolean updateLabel(Long labelId, Long writerId, String newTitle);

    /**
     * 删除标签，只有标签是当前作者创建的才能删除
     *
     * @param writerId id
     * @param labelId  标签id
     * @return 删除成功返回true
     */
    boolean deleteLabel(Long writerId, Long labelId);

    /**
     * 获得所有标签
     *
     * @return 查询结果
     */
    ResultModel<PageResult<LabelDTO>> listLabel(Integer pageNum, Integer pageSize);

    /**
     * 获得指定标签
     *
     * @param labelId 标签id
     * @return 查询结果
     */
    LabelDTO getLabel(Long labelId);

    /**
     * 获取指定作者创建的所有标签
     *
     * @param writerId id
     * @return 查询结果
     */
    ResultModel<PageResult<LabelDTO>> listWritersLabel(Long writerId, Integer pageNum, Integer pageSize);
}
