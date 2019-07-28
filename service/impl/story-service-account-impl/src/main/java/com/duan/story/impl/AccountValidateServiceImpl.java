package com.duan.story.impl;

import com.duan.story.dao.AccountDao;
import com.duan.story.service.AccountValidateService;
import com.duan.story.common.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Service
public class AccountValidateServiceImpl implements AccountValidateService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean checkAccountExist(Integer id) {
        return accountDao.findAccountById(id) != null;
    }

    @Override
    public boolean checkUserName(String username) {
        if (Utils.isStringBlank(username)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean checkPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }

        String regex = "^(?:(?=.*[A-z])(?=.*[0-9])).{6,20}$";
        return password.matches(regex);
    }

}
