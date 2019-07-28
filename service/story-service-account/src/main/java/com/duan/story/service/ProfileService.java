package com.duan.story.service;


import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.ProfileDTO;

/**
 * Created on 2017/12/14.
 *
 * @author DuanJiaNing
 */
public interface ProfileService {

    /**
     * 新增资料
     *
     * @return 新纪录id
     */
    ResultModel<Integer> insertProfile(ProfileDTO profile);

    /**
     * 更新资料
     *
     * @return 更新失败为false
     */
    ResultModel<Boolean> updateProfile(ProfileDTO profile);

    /**
     * 删除资料
     *
     * @param writerId id
     * @return 删除成功为true
     */
    boolean deleteProfile(Integer writerId);

    /**
     * 查询资料
     *
     * @param writerId id
     * @return 查询结果
     */
    ProfileDTO getProfile(Integer writerId);

    /**
     * 通过电话号码获得资料
     *
     * @param phone 电话号码
     * @return 结果
     */
    ProfileDTO getProfileByPhone(String phone);
}
