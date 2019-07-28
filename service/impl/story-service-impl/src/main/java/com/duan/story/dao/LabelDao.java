package com.duan.story.dao;

import com.duan.story.entity.Label;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/12/22.
 *
 * @author DuanJiaNing
 */
@Repository
public interface LabelDao extends BaseDao<Label> {

    List<Label> listLabelByIds(@Param("ids") List<Integer> ids);

    Label findLabelById(Integer id);

    List<Label> listLabel();

    List<Label> listLabelByWriterId(@Param("writerId") Integer writerId);

    Integer countByWriterId(Integer writerId);
}
