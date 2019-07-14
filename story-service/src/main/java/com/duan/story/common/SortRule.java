package com.duan.story.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created on 2017/12/16.
 * 排序规则
 *
 * @author DuanJiaNing
 */
@Getter
@AllArgsConstructor
public class SortRule implements Serializable {

    private final Rule rule;
    private final Order order;

    public static SortRule valueOf(String ruleName, String orderName) {
        Rule rule = Rule.valueOf(ruleName);
        Order order = Order.valueOf(orderName);
        return new SortRule(rule, order);
    }

    public enum Order implements Serializable {

        ASC("asc"),
        DESC("desc");

        private final String code;

        Order(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public enum Rule implements Serializable {

        COMMENT_COUNT("comment_count"),
        VIEW_COUNT("view_count"),
        REPLY_COMMENT_COUNT("reply_comment_count"),
        COLLECT_COUNT("collect_count"),
        LIKE_COUNT("like_count"),
        WORD_COUNT("word_count"),
        RELEASE_DATE("release_date");

        private final String code;

        Rule(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
