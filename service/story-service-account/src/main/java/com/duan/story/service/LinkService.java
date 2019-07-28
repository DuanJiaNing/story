package com.duan.story.service;


import com.duan.story.common.PageResult;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.LinkDTO;

/**
 * Created on 2017/12/18.
 *
 * @author DuanJiaNing
 */
public interface LinkService {

    /**
     * 获取友情链接，自动按优先级从高到底排序
     *
     * @param writerId id
     * @return 查询结果
     */
    ResultModel<PageResult<LinkDTO>> listLink(Integer writerId, Integer pageNum, Integer pageSize);

    /**
     * 新增友情链接
     *
     * @param writerId id
     * @param icon     图标
     * @param title    名字
     * @param url      url
     * @param bewrite  描述
     * @return 新纪录id
     */
    Integer insertLink(Integer writerId, String icon, String title, String url, String bewrite);

    /**
     * 删除链接
     *
     * @param linkId 链接id
     * @return 删除成功为true
     */
    boolean deleteLink(Integer linkId);

    /**
     * 更新链接
     *
     * @param linkId     链接id
     * @param newIcon    新的图片，不改变传 null
     * @param newTitle   新的标题，不改变传 null
     * @param newUrl     新的url，不改变传 null
     * @param newBewrite 新的描述，不改变传 null
     * @return 更新失败为false
     */
    boolean updateLink(Integer linkId, String newIcon, String newTitle, String newUrl, String newBewrite);

    /**
     * 获取链接
     *
     * @param linkId 链接id
     * @return 结果
     */
    LinkDTO getLink(Integer linkId);
}
