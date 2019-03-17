package com.phantom.user.controller;

import com.google.gson.Gson;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.UserDao;
import com.phantom.model.entity.User;
import com.phantom.user.request.UserBean;
import com.phantom.user.service.UserService;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private static final Gson gson = new Gson();
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RequestUtils requestUtils;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    String registerUser(HttpServletRequest request, HttpServletResponse response) {
        UserBean userBean = new UserBean(request);
        if (userBean.isValidUser()) {
            logger.info("User : " + userBean.getUserName() + " is registered successfully");
            userService.setCookie(response, userBean.getUserName(), userBean.getSsoToken());
            userService.insertUserDetails(userBean);
            return "{\"userStatus\": \"true\"}";
        } else {
            return "{\"userStatus\": \"false\"}";
        }
    }

    @RequestMapping(value = "getUserDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getUserDetails(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "ssoToken");
        User user = userDao.getUserDetailsBySSOToken(ssoToken);
        if (user != null) {
            return gson.toJson(user);
        }
        return "{\"userStatus\": \"false\"}";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    Boolean doLogin(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String ssoToken = userService.isValidUser(userName, password);
        if (!StringUtils.isEmpty(ssoToken)) {
            userService.setCookie(response,userName,ssoToken);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public @ResponseBody
    String logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            return "{\"logoutStatus\": \"true\"}";
        } catch (Exception e) {
            logger.error("Exception occurred while logging out user ", e);
            return "{\"logoutStatus\": \"false\"}";
        }
    }

}
