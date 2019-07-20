package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.service.AccountService;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

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

        char[] cs = "abcdefghijklmnopqrstyvwxyz1234567890".toCharArray();

        int count = 8;
        for (int i = 0; i < count; i++) {
            String name = RandomString.make(4);
            StringBuilder ps = new StringBuilder();
            Random random = new Random();
            for (int j = 0; j < 8; j++) {
                ps.append(cs[random.nextInt(cs.length)]);
            }
            ResultModel<AccountDTO> rs = test.insertAccount(name, ps.toString());
            outJson(rs);

        }

    }

}
