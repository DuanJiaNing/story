package com.duan.story;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    protected void out(Object obj) {
        System.out.println("out: " + obj);
    }

}
