package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.service.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
public class AccountServiceTest extends T {

    @Autowired
    private AccountService test;

    @Test
    public void insertAccount() {

        // for farther test
        ResultModel<AccountDTO> duan = test.insertAccount("duan", "abc123456");

        ResultModel<AccountDTO> tom = test.insertAccount("tom", "111111");
        Assert.assertEquals(tom.getCode(), 5002);

    }

}
