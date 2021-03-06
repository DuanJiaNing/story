package com.duan.story.dao;

import com.duan.story.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * Created on 2017/12/19.
 *
 * @author DuanJiaNing
 */
@Repository
public interface AccountDao extends BaseDao<Account> {

    Account findAccountByUsername(String username);

    Account findAccountById(Integer id);

}
