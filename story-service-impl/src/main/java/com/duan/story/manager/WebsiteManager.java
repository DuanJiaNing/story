package com.duan.story.manager;

import com.duan.story.dao.AccountDao;
import com.duan.story.entity.Account;
import com.duan.story.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2019/7/17.
 *
 * @author DuanJiaNing
 */
@Component
public class WebsiteManager {

    @Autowired
    private AccountDao accountDao;

    public List<Integer> getActiveWriterIds(int count) {

        // UPDATE: 2018/5/1 更新 完善策略

        PageHelper.startPage(1, count);
        PageInfo<Account> info = new PageInfo<>(accountDao.ListAccount());
        if (ResultUtil.isPageEmpty(info)) {
            return null;
        }

        return info.getList().stream()
                .map(Account::getId)
                .collect(Collectors.toList());
    }
}
