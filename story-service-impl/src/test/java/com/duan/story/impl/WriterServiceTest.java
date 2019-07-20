package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.dto.WriterDTO;
import com.duan.story.service.WriterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2019/7/19.
 *
 * @author DuanJiaNing
 */
public class WriterServiceTest extends T {

    @Autowired
    private WriterService test;

    @Test
    public void getWriterDTO() {
        WriterDTO dto = test.getWriterDTO(T.account_id.get(0));
        outJson(dto);
    }

    @Test
    public void listWriter() {
        List<WriterDTO> dtos = test.listWriter(Arrays.asList(T.account_id.get(0), T.account_id.get(1)));
        outJson(dtos);
    }

}
