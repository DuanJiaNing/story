package com.duan.story.service;


import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.common.dto.ProfileDTO;
import com.duan.story.common.enums.RoleEnum;

/**
 * Created on 2017/12/14.
 *
 * @author DuanJiaNing
 */
public interface AccountService {

    /**
     * 新增账户
     */
    ResultModel<AccountDTO> createAccount(AccountDTO account, ProfileDTO profile, RoleEnum role);

    /**
     * 根据用户名获取账户
     *
     * @param username 用户名
     * @return 查询结果
     */
    AccountDTO getAccountByUsername(String username);

    /**
     * 删除账号
     *
     * @param id id
     * @return 删除成功返回 true
     */
    boolean deleteAccount(Integer id);

    /**
     * 更新用户名
     *
     * @param id          id
     * @param newUsername 新的用户名
     * @return 更新成功返回 true
     */
    boolean updateAccountUsername(Integer id, String newUsername);

    /**
     * 更新密码
     *
     * @param id          id
     * @param oldPassword 旧密码
     * @param newPassword 新的密码
     * @return 更新成功返回 true
     */
    boolean updateAccountPassword(Integer id, String oldPassword, String newPassword);

    /**
     * 根据电话号码获得账户
     *
     * @param phone 电话号码
     * @return 不存在返回 null
     */
    AccountDTO getAccountByPhone(String phone);

    /**
     * 根据 id 获取账号
     *
     * @param id id
     * @return 不存在返回 null
     */
    AccountDTO getAccount(Integer id);
}
