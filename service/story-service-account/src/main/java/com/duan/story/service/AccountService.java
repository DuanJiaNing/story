package com.duan.story.service;


import com.duan.story.common.dto.AccountDTO;

/**
 * Created on 2017/12/14.
 *
 * @author DuanJiaNing
 */
public interface AccountService {

    AccountDTO createAccount(AccountDTO account) throws Exception;

    AccountDTO getAccount(Integer id);
}
