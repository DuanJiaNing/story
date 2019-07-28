package com.duan.story.impl;

import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.ProfileDTO;
import com.duan.story.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/7/19.
 *
 * @author DuanJiaNing
 */
@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {

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
