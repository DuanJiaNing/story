package com.duan.story;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


/**
 * Created on 2018/9/14.
 *
 * @author DuanJiaNing
 */
@EnableDubbo(scanBasePackages = "com.duan.story")
@PropertySource("classpath:/dubbo-consumer.properties")
//@ComponentScan(value = {"com.duan.story"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
