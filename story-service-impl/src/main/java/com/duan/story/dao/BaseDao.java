package com.duan.story.dao;

/**
 * Created on 2017/12/12.
 *
 * @author DuanJiaNing
 */
public interface BaseDao<T> {

    /**
     * 更新数据
     *
     * @param t 数据
     * @return 操作影响的行数
     */
    int update(T t);

    /**
     * 根据id删除数据
     *
     * @param id id
     * @return 操作影响的行数
     */
    int delete(Integer id);

    /**
     * 新增数据
     *
     * @param t 数据
     * @return 操作影响的行数
     */
    int insert(T t);

}
