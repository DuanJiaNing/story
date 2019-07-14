package com.duan.story.common.enums;

import java.io.Serializable;

/**
 * Created on 2017/12/12.
 *
 * @author DuanJiaNing
 */
public enum StoryStatusEnum implements Serializable {

    PUBLIC(1),
    PRIVATE(2),
    DELETED(3),
    VERIFY(0);

    private final int code;

    StoryStatusEnum(int code) {
        this.code = code;
    }

    public static StoryStatusEnum valueOf(int code) {
        for (StoryStatusEnum anEnum : values()) {
            if (anEnum.getCode() == code)
                return anEnum;
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
