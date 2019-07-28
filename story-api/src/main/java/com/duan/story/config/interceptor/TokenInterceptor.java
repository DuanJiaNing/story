package com.duan.story.config.interceptor;


import com.alibaba.fastjson.JSON;
import com.duan.story.annonation.TokenNotRequired;
import com.duan.story.common.ResultModel;
import com.duan.story.common.util.TokenUtil;
import com.duan.story.service.OnlineService;
import com.duan.story.util.CurrentUserThreadLocal;
import com.duan.story.util.ResultUtils;
import com.duan.story.util.SpringUtils;
import com.duan.story.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2018/5/30.
 *
 * @author DuanJiaNing
 */
@Slf4j
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (!canHandle(handler)) {
            return true;
        }

        String token = Utils.getToken();

        if (token == null || illegalToken(token)) {
            ResultModel resultModel = ResultUtils.fail(1001);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultModel));

            return false;
        }

        if (expiredToken(token)) {
            ResultModel resultModel = ResultUtils.fail(1002);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultModel));

            return false;
        }

        return true;
    }

    private boolean illegalToken(String token) {
        try {
            TokenUtil.decode(token);
        } catch (Exception e) {
            log.error("got error when decode token: %s", e);
            return true;
        }

        return false;
    }


    private boolean expiredToken(String token) {

        try {
            OnlineService onlineService = SpringUtils.getBean(OnlineService.class);
            Integer bloggerId = onlineService.getLoginWriterId(token);
            if (bloggerId == null) {
                return true;
            }

            CurrentUserThreadLocal.setCurrentUid(bloggerId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    private boolean canHandle(Object handler) {

        if (!(handler instanceof HandlerMethod)) {
            return false;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> clasz = handlerMethod.getBeanType();
        if (clasz.isAnnotationPresent(TokenNotRequired.class)) {
            return false;
        }

        TokenNotRequired checkToken = handlerMethod.getMethod().getAnnotation(TokenNotRequired.class);
        if (checkToken != null) {
            return false;
        }

        return true;
    }


}
