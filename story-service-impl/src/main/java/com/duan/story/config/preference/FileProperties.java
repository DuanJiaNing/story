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
@ConfigurationProperties(prefix = "preference.file")
@Configuration
public class FileProperties {

    /**
     * 批量导入时临时 zip 文件路径
     */
    private String patchImportStoryTempPath;

    /**
     * 批量下载时临时 zip 文件和 md/html 文件路径
     */
    private String patchDownloadStoryTempPath;

    /**
     *  lucene生成的索引保存路径
     */
    private String luceneIndexDir;
}
