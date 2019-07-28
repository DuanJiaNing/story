package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.common.dto.ProfileDTO;
import com.duan.story.common.enums.RoleEnum;
import com.duan.story.service.AccountService;
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
    public void createAccount() {

        AccountDTO a = new AccountDTO();
        a.setPassword("abc123456");
        a.setUsername("David");

        ProfileDTO p = new ProfileDTO();
        p.setEmail("aimeimeits@gmail.com");
        p.setAboutMe("about me");
        p.setMotto("This is admin");

        ResultModel<AccountDTO> rs = test.createAccount(a, p, RoleEnum.ADMIN);
        outJson(rs);

    }

}
