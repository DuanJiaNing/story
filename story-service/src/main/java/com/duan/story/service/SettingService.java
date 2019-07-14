package com.duan.story.service;


import com.duan.story.common.dto.SettingDTO;

/**
 * Created on 2018/3/26.
 *
 * @author DuanJiaNing
 */
public interface SettingService {

    /**
     * 获得配置
     *
     * @param writerId id
     * @return 查询结果
     */
    SettingDTO getSetting(Long writerId);

}
