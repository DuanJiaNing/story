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
@ConfigurationProperties(prefix = "preference.default")
@Configuration
public class DefaultProperties {

    /**
     * 读者默认请求故事列表时默认返回的条目数量
     */
    private Integer storyCount;

    /**
     * 默认返回的评论数量
     */
    private Integer commentCount;

    /**
     * 收藏故事默认请求条数
     */
    private Integer collectCount;

    /**
     * 默认获取活跃作者数
     */
    private Integer activeWriterCount;

}
