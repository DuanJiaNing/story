package com.duan.story.service.tool;

/**
 * Created on 2018/4/7.
 *
 * @author DuanJiaNing
 */
public interface EmailService {

    /**
     * 发送反馈邮件
     *
     * @param writerId 发送者 id
     * @param content   邮件内容
     * @param subject   主题
     * @param contact   发送者留的联系方式，如果有的话
     * @return 邮件发送成功返回 true
     */
    boolean sendFeedback(Integer writerId, String subject, String content, String contact);

}
