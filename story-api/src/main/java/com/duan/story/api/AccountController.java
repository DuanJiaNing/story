package com.duan.story.api;

import com.duan.story.common.dto.AccountDTO;
import com.duan.story.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2019/7/28.
 *
 * @author DuanJiaNing
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Reference
    private AccountService accountService;

    @PostMapping
    @ResponseBody
    public AccountDTO create(@RequestBody AccountDTO account) throws Exception {
        return accountService.createAccount(account);
    }

    @GetMapping
    @ResponseBody
    public AccountDTO get(@RequestParam Integer id) {
        return accountService.getAccount(id);
    }

}
