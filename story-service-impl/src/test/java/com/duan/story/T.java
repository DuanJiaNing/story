package com.duan.story;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class T {

    public final static int account_duan_id = 1;
    public final static List<Integer> label_ids = Arrays.asList(1, 2, 3);
    public final static List<Integer> category_ids = Arrays.asList(1, 2, 3);

    protected void out(Object obj) {
        System.out.println("out: " + obj);
    }

}
