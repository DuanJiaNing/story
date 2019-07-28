package com.duan.story.config;

import com.duan.story.common.util.SpringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;

/**
 * Created on 2018/9/23.
 *
 * @author DuanJiaNing
 */
@Configuration
public class AppConfig implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.setApplicationContext(applicationContext);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames(StringUtils.commaDelimitedListToStringArray(
                StringUtils.trimAllWhitespace("messages")));

        messageSource.setDefaultEncoding(Charset.forName("UTF-8").name());
        messageSource.setFallbackToSystemLocale(true);
        messageSource.setCacheSeconds(-1);
        messageSource.setAlwaysUseMessageFormat(false);
        return messageSource;
    }

}
