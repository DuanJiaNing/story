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
     * @return 新纪录id
     */
    ResultModel<LabelDTO> insertLabel(LabelDTO label);

    /**
     * 修改标签
     *
     * @param labelId  标签id
     * @param writerId 标签所有者
     * @param newTitle 新标签名
     * @return 更新失败为false
     */
    boolean updateLabel(Integer labelId, Integer writerId, String newTitle);

    /**
     * 删除标签，只有标签是当前作者创建的才能删除
     *
     * @param writerId id
     * @param labelId  标签id
     * @return 删除成功返回true
     */
    boolean deleteLabel(Integer writerId, Integer labelId);

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
    LabelDTO getLabel(Integer labelId);

    /**
     * 获取指定作者创建的所有标签
     *
     * @param writerId id
     * @return 查询结果
     */
    ResultModel<PageResult<LabelDTO>> listWritersLabel(Integer writerId, Integer pageNum, Integer pageSize);
}
