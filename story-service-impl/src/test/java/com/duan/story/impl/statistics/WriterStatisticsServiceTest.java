package com.duan.story.impl.statistics;

import com.duan.story.T;
import com.duan.story.service.statistics.WriterStatisticsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/7/19.
 *
 * @author DuanJiaNing
 */
public class WriterStatisticsServiceTest extends T {

    @Autowired
    private WriterStatisticsService test;

    @Test
    public void getWriterStatistics() {
        for (Integer id : T.account_id) {
            outJson(test.getWriterStatistics(id));
        }
    }


}
