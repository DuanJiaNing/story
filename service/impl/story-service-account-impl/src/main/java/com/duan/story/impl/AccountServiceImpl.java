package com.duan.story.impl;

import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.common.dto.ProfileDTO;
import com.duan.story.common.enums.RoleEnum;
import com.duan.story.dao.AccountDao;
import com.duan.story.dao.ProfileDao;
import com.duan.story.dao.RoleDao;
import com.duan.story.dao.SettingDao;
import com.duan.story.entity.Account;
import com.duan.story.entity.Profile;
import com.duan.story.entity.Role;
import com.duan.story.entity.Setting;
import com.duan.story.service.AccountService;
import com.duan.story.service.AccountValidateService;
import com.duan.story.common.util.DataConverter;
import com.duan.story.common.util.ResultUtils;
import com.duan.story.common.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private SettingDao settingDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private AccountValidateService accountValidateService;

    @Override
    @Transactional
    public ResultModel<AccountDTO> createAccount(AccountDTO account, ProfileDTO profile, RoleEnum role) {
        if (!accountValidateService.checkUserName(account.getUsername())) {
            return ResultUtils.fail("invalid username");
        }

        if (!accountValidateService.checkPassword(account.getPassword())) {
            return ResultUtils.fail("invalid password");
        }

        String shaPwd;
        try {
            shaPwd = new BigInteger(Utils.toSha(account.getPassword())).toString();
        } catch (NoSuchAlgorithmException e) {
            return ResultUtils.fail("encoding password fail", e);
        }

        Account a = new Account();
        a.setUsername(account.getUsername());
        a.setPassword(shaPwd);
        if (accountDao.insert(a) == 0) {
            return ResultUtils.fail("insert account fail");
        }

        Integer accountId = a.getId();
        Setting setting = new Setting();
        setting.setAccountId(accountId);
        if (settingDao.insert(setting) == 0) {
            return ResultUtils.fail("insert setting fail");
        }

        Role r = new Role();
        r.setRole(role.toString());
        r.setAccountId(accountId);
        if (roleDao.insert(r) == 0) {
            return ResultUtils.fail("insert role fail");
        }

        Profile p = DataConverter.map(profile, Profile.class);
        if (p == null) {
            return ResultUtils.fail();
        }
        p.setAccountId(a.getId());
        if (profileDao.insert(p) == 0) {
            return ResultUtils.fail("insert profile fail");
        }

        return ResultUtils.success(DataConverter.map(account, AccountDTO.class));
    }

    @Override
    public AccountDTO getAccountByUsername(String username) {
        Account account = accountDao.findAccountByUsername(username);
        return DataConverter.map(account, AccountDTO.class);
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
