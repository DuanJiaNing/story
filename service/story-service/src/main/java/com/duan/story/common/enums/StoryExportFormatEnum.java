package com.duan.story.common.enums;


/**
 * Created on 2018/4/5.
 *
 * @author DuanJiaNing
 */
public enum StoryExportFormatEnum {

    MD(0),
    HTML(1);

    private final int code;

    StoryExportFormatEnum(int code) {
        this.code = code;
    }

    public static boolean contains(String type) {
        if (type == null) return false;

        return type.equalsIgnoreCase(MD.name()) || type.equalsIgnoreCase(HTML.name());
    }

    public static StoryExportFormatEnum get(String type) {
        if (contains(type))
            return StoryExportFormatEnum.valueOf(type.toUpperCase());
        else return null;
    }

    public int getCode() {
        return code;
    }

}
