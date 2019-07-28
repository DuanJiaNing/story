package com.duan.story.common.enums;

/**
 * Created on 2017/12/14.
 *
 * @author DuanJiaNing
 */
public enum StoryCommentStatusEnum {

    /**
     * 正在审核
     */
    BEING_AUDITED(0),

    /**
     * 审核通过
     */
    RIGHTFUL(1);

    private final int code;

    StoryCommentStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
