package com.duan.story.service.validate;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
public interface WriterValidateService {

    /**
     * 检查账号是否存在
     *
     * @param id id
     * @return 存在返回true
     */
    boolean checkAccountExist(Long id);

    /**
     * 检查类别是否存在
     *
     * @param writerId   id
     * @param categoryId 类别id
     * @return 存在时返回true
     */
    boolean checkCategoryExist(Long writerId, Long categoryId);

    /**
     * 注册时检查用户名合法性
     *
     * @param username 用户名
     * @return 合法返回true
     */
    boolean checkUserName(String username);

    /**
     * 校验密码：6-12 为，由字母和数字组成
     *
     * @param password 密码
     * @return 合法返回true
     */
    boolean checkPassword(String password);

}
