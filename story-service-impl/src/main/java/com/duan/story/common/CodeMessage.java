package com.duan.story.common;

/**
 * Created on 2018/9/13.
 *
 * @author DuanJiaNing
 */
public enum CodeMessage {

// error -------------------------------------------------------------------------------------------------//

    /**
     * 故事不存在
     */
    STORY_NOT_EXIST(5002),

    /**
     * 故事排序规则未定义
     */
    STORY_SORT_RULE_UNDEFINED(5003),

    /**
     * 排序顺序未定义
     */
    SORT_ORDER_UNDEFINED(5004),

    /**
     * 未登录
     */
    NOT_LOGGED_IN(5016),

    /**
     * 内容违规
     */
    CONTENT_ILLEGAL(5017),

    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXIST(5022),

    /**
     * 密码错误
     */
    PASSWORD_INCORRECT(5023),

// common -------------------------------------------------------------------------------------------------//

    /**
     * 数据是空的
     */
    COMMON_EMPTY_RESULT(5006),

    /**
     * 操作失败
     */
    COMMON_OPERATE_FAIL(5007),

    /**
     * 参数不正确
     */
    COMMON_PARAMETER_ILLEGAL(5008),

    /**
     * 未指明操作
     */
    COMMON_UNSPECIFIED_OPERATION(5009),

    /**
     * 未知错误
     */
    COMMON_UNKNOWN_ERROR(5010),

    /**
     * 请求参数缺失
     */
    COMMON_MISSING_REQUEST_PARAMETER(5011),

    /**
     * 链接不存在
     */
    COMMON_UNKNOWN_LINK(5013),

    /**
     * 未授权
     */
    COMMON_UNAUTHORIZED(5014),

    /**
     * 未知类别
     */
    COMMON_UNKNOWN_CATEGORY(5015),

    /**
     * 重复数据
     */
    COMMON_DUPLICATION_DATA(5018),

    /**
     * 参数格式不正确
     */
    COMMON_PARAMETER_FORMAT_ILLEGAL(5019),

    /**
     * 参数类型不正确
     */
    COMMON_PARAMETER_TYPE_MISMATCH(5020),

    /**
     * 用户反馈
     */
    COMMON_FEEDBACK_TITLE(3000);

    private final int code;

    CodeMessage(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
