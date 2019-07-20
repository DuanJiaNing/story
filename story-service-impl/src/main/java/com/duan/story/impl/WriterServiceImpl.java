package com.duan.story.impl;

import com.duan.story.common.dto.ProfileDTO;
import com.duan.story.common.dto.WriterDTO;
import com.duan.story.dao.AccountDao;
import com.duan.story.dao.ProfileDao;
import com.duan.story.entity.Account;
import com.duan.story.entity.Profile;
import com.duan.story.service.WriterService;
import com.duan.story.util.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/7/14.
 *
 * @author DuanJiaNing
 */
@Service
public class WriterServiceImpl implements WriterService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ProfileDao profileDao;

    @Override
    public List<WriterDTO> listWriter(List<Integer> ids) {
        List<WriterDTO> writers = new ArrayList<>();
        ids.forEach(id -> writers.add(getWriterDTO(id)));

        return writers;
    }

    @Override
    public WriterDTO getWriterDTO(Integer id) {
        WriterDTO w = new WriterDTO();

        Account account = accountDao.findAccountById(id);
        w.setId(account.getId());
        w.setRegisterDate(account.getRegisterDate());
        w.setUsername(account.getUsername());

        Profile profile = profileDao.findProfileByWriterId(w.getId());
        w.setProfile(DataConverter.map(profile, ProfileDTO.class));
        return w;
    }

}
