package com.duan.story.common.util;

import org.modelmapper.ModelMapper;

/**
 * Created on 2018/10/1.
 *
 * @author DuanJiaNing
 */
public class DataConverter {
    private static ModelMapper mapper = new ModelMapper();

    public static <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationType);
    }
}
