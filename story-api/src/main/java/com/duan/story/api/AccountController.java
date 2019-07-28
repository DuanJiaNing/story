package com.duan.story.api;

import com.duan.story.annonation.TokenNotRequired;
import com.duan.story.common.ResultModel;
import com.duan.story.common.dto.AccountDTO;
import com.duan.story.common.dto.ProfileDTO;
import com.duan.story.common.enums.RoleEnum;
import com.duan.story.common.vo.SignUpVO;
import com.duan.story.restful.ResultBean;
import com.duan.story.service.AccountService;
import com.duan.story.service.AccountValidateService;
import com.duan.story.util.DataConverter;
import com.duan.story.util.ResultUtils;
import com.duan.story.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/7/28.
 *
 * @author DuanJiaNing
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountValidateService accountValidateService;

    @PostMapping
    @TokenNotRequired
    public ResultBean signUp(@RequestBody SignUpVO vo) {
        if (Utils.isStringBlank(vo.getUsername())) {
            return ResultUtils.fail(1003);
        }

        if (!accountValidateService.checkUserName(vo.getUsername())) {
            return ResultUtils.fail(1004);
        }

        if (Utils.isStringBlank(vo.getPassword())) {
            return ResultUtils.fail(1005);
        }

        if (!accountValidateService.checkPassword(vo.getPassword())) {
            return ResultUtils.fail(1006);
        }

        AccountDTO account = DataConverter.map(vo, AccountDTO.class);
        ProfileDTO profile = new ProfileDTO();
        profile.setEmail(vo.getEmail());
        profile.setAboutMe(vo.getAboutMe());
        profile.setMotto(vo.getHomePageTitle());
        ResultModel<AccountDTO> aMode = accountService.createAccount(account, profile, RoleEnum.USER);
        if (!ResultUtils.isSuccess(aMode)) {
            log.error("[createAccount]: got error when sign up: %s", aMode.getMsg());
            return ResultUtils.fail(1007);
        }

        return ResultUtils.success();
    }

}
