package com.duan.story;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created on 2018/9/14.
 * dubbo 搭建参考 https://github.com/apache/incubator-dubbo-samples/blob/master/dubbo-samples-annotation/pom.xml
 *
 * @author DuanJiaNing
 */
@SpringBootApplication
//@EnableDubbo(scanBasePackages = "com.duan.story.api")
public class StoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoryApplication.class, args);
    }
}
