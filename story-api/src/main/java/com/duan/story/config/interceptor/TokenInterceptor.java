package com.duan.story.config.interceptor;


import com.alibaba.fastjson.JSON;
import com.duan.story.annonation.TokenNotRequired;
import com.duan.story.common.ResultModel;
import com.duan.story.common.util.TokenUtil;
import com.duan.story.service.OnlineService;
import com.duan.story.util.CodeMessage;
import com.duan.story.util.CurrentUserThreadLocal;
import com.duan.story.util.SpringUtil;
import com.duan.story.util.Util;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2018/5/30.
 *
 * @author DuanJiaNing
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (!canHandle(handler)) {
            return true;
        }

        String token = Util.getToken();

        // 判断请求是否有 token，非法 token
        if (token == null || illegalToken(token)) {
            ResultModel resultModel = ResultModel.fail("token required", CodeMessage.TOKEN_REQUIRED.getCode());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultModel));

            return false;
        }

        // token 非法
        if (expiredToken(token)) {
            ResultModel resultModel = ResultModel.fail("invalid token", CodeMessage.INVALID_TOKEN.getCode());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(resultModel));

            return false;
        }

        return true;
    }

    /**
     * 非法 token
     * 无法解密的 token 即为非法 token
     */
    private boolean illegalToken(String token) {

        try {
            TokenUtil.decode(token);
        } catch (Exception e) {
            return true;
        }

        return false;
    }


    /**
     * token 已过期
     */
    private boolean expiredToken(String token) {

        try {
            OnlineService onlineService = SpringUtil.getBean(OnlineService.class);
            Long bloggerId = onlineService.getLoginWriterId(token);
            if (bloggerId == null) {
                return true;
            }

            CurrentUserThreadLocal.setCurrentUid(bloggerId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * 判断是否需要处理
     *
     * @return 不用处理返回 ture
     */
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
