package com.duan.story;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created on 2018/9/14.
 * dubbo 搭建参考 https://github.com/apache/incubator-dubbo-samples/blob/master/dubbo-samples-annotation/pom.xml
 *
 * @author DuanJiaNing
 */
@SpringBootApplication
@MapperScan("com.duan.story.dao")
@ImportResource("classpath:spring/spring-*.xml")
//@EnableDubbo(scanBasePackages = "com.duan.story.impl")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
