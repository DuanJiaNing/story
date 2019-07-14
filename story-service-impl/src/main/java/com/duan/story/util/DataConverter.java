package com.duan.story.util;

import org.modelmapper.ModelMapper;

/**
 * Created on 2018/10/1.
 *
 * @author DuanJiaNing
 */
public class DataConverter {
    private static ModelMapper mapper = new ModelMapper();

    public static <D> D map(Object source, Class<D> destinationType) {
        return mapper.map(source, destinationType);
    }
}
