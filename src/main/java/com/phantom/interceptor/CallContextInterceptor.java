package com.phantom.interceptor;

import com.phantom.model.entity.User;
import com.phantom.user.service.UserService;
import com.phantom.util.PhantomUtil;
import com.phantom.util.RequestUtils;
import com.phantom.util.UserKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallContextInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    RequestUtils requestUtils;

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String tokenId = requestUtils.getCookieValue(request, "ssoToken");
        if (tokenId == null) {
            tokenId = request.getParameter("ssoToken");
        }

        if (!PhantomUtil.isNullOrEmpty(tokenId)) {
            User user = userService.getUserDetails(tokenId);
            if (user != null) {
                UserKeeper.setUserDetails(user);
            }
        }
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) {
        UserKeeper.removeUserDetails();
    }
}
