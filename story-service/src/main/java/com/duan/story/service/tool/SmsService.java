package com.duan.story.service.tool;

import com.duan.story.common.ResultModel;

/**
 * Created on 2018/9/15.
 *
 * @author DuanJiaNing
 */
public interface SmsService {

    ResultModel sendSmsTo(String content, String phone);

}
