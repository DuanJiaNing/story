package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.LabelDTO;
import com.duan.story.service.LabelService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class LabelServiceTest extends T {

    @Autowired
    private LabelService labelService;

    @Test
    public void insertLabel() {

        LabelDTO l1 = new LabelDTO();
        l1.setTitle("4 label");
        l1.setWriterId(T.account_id.get(0));
        ResultModel<LabelDTO> fl = labelService.insertLabel(l1);
    }

}
