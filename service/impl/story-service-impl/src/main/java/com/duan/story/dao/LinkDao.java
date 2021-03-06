package com.duan.story.dao;

import com.duan.story.entity.Link;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2017/12/29.
 *
 * @author DuanJiaNing
 */
@Repository
public interface LinkDao extends BaseDao<Link> {

    List<Link> listLinkByWriterId(@Param("writerId") Integer writerId);

    Integer findLinkById(Integer id);

    int countLinkByWriterId(Integer writerId);
}
