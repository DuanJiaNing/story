package com.duan.story.dao;

import com.duan.story.entity.Setting;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created on 2018/3/26.
 *
 * @author DuanJiaNing
 */
@Repository
public interface SettingDao extends BaseDao<Setting> {

    Setting findSettingByWriterId(Long writerId);

}
