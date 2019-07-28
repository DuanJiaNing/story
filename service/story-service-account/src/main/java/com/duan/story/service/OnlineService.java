package com.duan.story.service;

import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.LoginResultDTO;
import com.duan.story.common.vo.LoginVO;

/**
 * Created on 2018/9/14.
 *
 * @author DuanJiaNing
 */
public interface OnlineService {

    /**
     * 获得登录账号id，未登录返回 null
     */
    Integer getLoginWriterId(String token);

    /**
     * 登入
     */
    ResultModel<LoginResultDTO> login(LoginVO account);

    /**
     * 登出
     */
    ResultModel logout(Integer uid);
}
