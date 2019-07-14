package com.duan.story.service;


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
     * @param writerId id
     * @param avatarId 头像id
     * @param phone    手机号
     * @param email    电子邮件
     * @param aboutMe  关于我
     * @param intro    一句话简介
     * @return 新纪录id
     */
    Integer insertProfile(Integer writerId, Integer avatarId, String phone, String email, String aboutMe, String intro);

    /**
     * 更新资料
     *
     * @param writerId   id
     * @param avatarId   头像id,不改变传 -1
     * @param newPhone   新的电话号码，不改变传 null
     * @param newEmail   新的邮箱，不改变传 null
     * @param newAboutMe 新的“关于我”，不改变传 null
     * @param newIntro   新的一句话简介，不改变传 null
     * @return 更新失败为false
     */
    boolean updateProfile(Integer writerId, Integer avatarId, String newPhone, String newEmail, String newAboutMe,
                          String newIntro);

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
