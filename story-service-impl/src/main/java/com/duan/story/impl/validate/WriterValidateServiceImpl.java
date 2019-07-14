package com.duan.story.impl.validate;

import com.duan.story.dao.AccountDao;
import com.duan.story.dao.CategoryDao;
import com.duan.story.service.validate.WriterValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Service
public class WriterValidateServiceImpl implements WriterValidateService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public boolean checkAccountExist(Integer id) {
        return accountDao.findAccountById(id) != null;
    }

    @Override
    public boolean checkCategoryExist(Integer writerId, Integer categoryId) {
        return categoryDao.findCategoryById(categoryId) != null;
    }

    @Override
    public boolean checkUserName(String username) {
        if (StringUtils.isEmpty(username) || accountDao.findAccountByUsername(username) != null) {
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
