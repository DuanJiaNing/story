package com.duan.story.dao;

import com.duan.story.entity.Setting;
import org.springframework.stereotype.Repository;

/**
 * Created on 2018/3/26.
 *
 * @author DuanJiaNing
 */
@Repository
public interface SettingDao extends BaseDao<Setting> {

    Setting findSettingByWriterId(Integer writerId);

}
