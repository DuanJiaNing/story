package com.duan.story.impl;

import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.dao.AccountDao;
import com.duan.story.dao.SettingDao;
import com.duan.story.entity.Account;
import com.duan.story.entity.Setting;
import com.duan.story.service.AccountService;
import com.duan.story.service.validate.WriterValidateService;
import com.duan.story.util.DataConverter;
import com.duan.story.util.ResultUtil;
import com.duan.story.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private SettingDao settingDao;

    @Autowired
    private WriterValidateService writerValidateService;

    @Override
    public ResultModel<AccountDTO> insertAccount(String username, String password) {
        if (!writerValidateService.checkUserName(username) || !writerValidateService.checkPassword(password)) {
            return ResultUtil.fail(5002);
        }

        String shaPwd;
        try {
            shaPwd = new BigInteger(Util.toSha(password)).toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("got error when encrypted password", e);
            return ResultUtil.fail();
        }

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(shaPwd);
        if (accountDao.insert(account) <= 0) {
            log.error("got error when insert account");
            return ResultUtil.fail();
        }

        Integer writerId = account.getId();
        Setting setting = new Setting();
        setting.setWriterId(writerId);
        if (settingDao.insert(setting) <= 0) {
            log.error("got error when insert account setting");
            return ResultUtil.fail();
        }

        return ResultUtil.success(DataConverter.map(account, AccountDTO.class));
    }

    @Override
    public AccountDTO getAccountByUsername(String username) {
        return null;
    }

    @Override
    public boolean deleteAccount(Integer id) {
        return false;
    }

    @Override
    public boolean updateAccountUsername(Integer id, String newUsername) {
        return false;
    }

    @Override
    public boolean updateAccountPassword(Integer id, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public AccountDTO getAccountByPhone(String phone) {
        return null;
    }

    @Override
    public AccountDTO getAccount(Integer id) {
        return null;
    }

}
