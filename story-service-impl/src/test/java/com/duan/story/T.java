package com.duan.story;

import com.alibaba.fastjson.JSONObject;
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

    public final static List<Integer> profile_id = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    public final static List<Integer> account_id = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    public final static List<Integer> story_id = Arrays.asList(1);
    public final static List<Integer> label_ids = Arrays.asList(1, 2, 3);
    public final static List<Integer> category_ids = Arrays.asList(1, 2, 3);

    protected void outJson(Object obj) {
        System.out.println("\n" + JSONObject.toJSON(obj) + "\n");
    }

}
