package com.duan.story.config.preference;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2018/9/15.
 *
 * @author DuanJiaNing
 */
@Data
@ConfigurationProperties(prefix = "preference.website")
@Configuration
public class WebsiteProperties {

    /**
     * 网站管理者的邮箱（反馈邮件发送到的邮箱）
     */
    private String managerEmail;

    /**
     * 配置了smtp 的邮件发送者
     */
    private String senderMail;

    /**
     * 配置了smtp 的邮件发送者的授权码
     */
    private String senderMailPassword;

}
