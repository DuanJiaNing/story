package com.duan.story.service;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
public interface AccountValidateService {

    /**
     * 检查账号是否存在
     *
     * @param id id
     * @return 存在返回true
     */
    boolean checkAccountExist(Integer id);

    /**
     * 注册时检查用户名合法性
     *
     * @param username 用户名
     * @return 合法返回true
     */
    boolean checkUserName(String username);

    /**
     * 校验密码：6-12 位，由字母和数字组成
     *
     * @param password 密码
     * @return 合法返回true
     */
    boolean checkPassword(String password);

}
