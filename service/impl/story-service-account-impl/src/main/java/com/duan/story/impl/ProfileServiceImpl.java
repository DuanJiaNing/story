package com.duan.story.impl;

import com.duan.story.common.dto.ProfileDTO;
import com.duan.story.dao.ProfileDao;
import com.duan.story.entity.Profile;
import com.duan.story.service.ProfileService;
import com.duan.story.util.DataConverter;
import com.duan.story.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/7/19.
 *
 * @author DuanJiaNing
 */
@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;

    @Override
    public ResultModel<Integer> insertProfile(ProfileDTO profile) {
        if (profile.getWriterId() == null) {
            log.error("writerId can not be null");
            return ResultUtil.fail(5002);
        }

        Profile p = DataConverter.map(profile, Profile.class);
        if (profileDao.insert(p) <= 0) {
            return ResultUtil.fail();
        }

        return ResultUtil.success(p.getId());
    }

    @Override
    public ResultModel<Boolean> updateProfile(ProfileDTO profile) {
        return null;
    }

    @Override
    public boolean deleteProfile(Integer writerId) {
        return false;
    }

    @Override
    public ProfileDTO getProfile(Integer writerId) {
        return null;
    }

    @Override
    public ProfileDTO getProfileByPhone(String phone) {
        return null;
    }
}
