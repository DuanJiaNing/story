package com.duan.story.impl;

import com.duan.story.T;
import com.duan.story.common.dto.ProfileDTO;
import com.duan.story.service.ProfileService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

/**
 * Created on 2019/7/19.
 *
 * @author DuanJiaNing
 */
public class ProfileServiceTest extends T {

    @Autowired
    private ProfileService test;

    @Test
    public void insertProfile() {
        ProfileDTO dto = new ProfileDTO();
        dto.setAboutMe("about me");
        dto.setEmail("email@mail.com");
        dto.setIntro("this is intro");
        Random random = new Random();
        for (Integer id : T.account_id) {
            dto.setPhone(String.valueOf(random.nextInt(900000000) * 1000));
            dto.setWriterId(id);
            ResultModel<Integer> model = test.insertProfile(dto);
            outJson(model);
        }
    }

}
