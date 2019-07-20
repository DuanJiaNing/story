package com.duan.story.util;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

/**
 * Created on 2018/10/1.
 *
 * @author DuanJiaNing
 */
@Slf4j
public class DataConverter {
    private static ModelMapper mapper = new ModelMapper();

    public static <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            log.error("ModelMapper source con not be null");
            return null;
        }
        return mapper.map(source, destinationType);
    }
}
