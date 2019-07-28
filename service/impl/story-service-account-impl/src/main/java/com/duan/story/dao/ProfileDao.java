package com.duan.story.dao;

import com.duan.story.entity.Profile;
import org.springframework.stereotype.Repository;

/**
 * Created on 2017/12/25.
 *
 * @author DuanJiaNing
 */
@Repository
public interface ProfileDao extends BaseDao<Profile> {

    Profile findProfileByWriterId(Integer writerId);

    Profile findProfileByPhone(String phone);
}
