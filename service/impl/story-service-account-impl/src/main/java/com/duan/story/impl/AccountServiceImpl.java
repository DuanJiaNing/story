package com.duan.story.impl;

import com.duan.story.DataConverter;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.dao.AccountDao;
import com.duan.story.entity.Account;
import com.duan.story.service.AccountService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public AccountDTO createAccount(AccountDTO account) throws Exception {

        Account a = new Account();
        a.setUsername(account.getUsername());
        a.setPassword(account.getPassword());
        if (accountDao.insert(a) == 0) {
            throw new Exception("insert account fail");
        }

        return DataConverter.map(a, AccountDTO.class);
    }

    @Override
    public AccountDTO getAccount(Integer id) {
        Account a = accountDao.findAccountById(id);
        return DataConverter.map(a, AccountDTO.class);
    }

}
