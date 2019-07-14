package com.duan.story.service;

import com.duan.story.common.dto.WriterDTO;

import java.util.List;

/**
 * Created on 2019/6/26.
 *
 * @author DuanJiaNing
 */
public interface WriterService {

    List<WriterDTO> listWriter(List<Integer> ids);

}
