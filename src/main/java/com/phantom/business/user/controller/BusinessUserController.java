package com.phantom.business.user.controller;

import com.google.gson.Gson;
import com.phantom.business.user.request.BusinessUserBean;
import com.phantom.business.user.service.BusinessUserService;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.BusinessUserDao;
import com.phantom.model.entity.BusinessUser;
import com.phantom.model.entity.User;
import com.phantom.user.request.UserBean;
import com.phantom.user.service.UserService;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "businessUser")
public class BusinessUserController {
    private static final Gson gson = new Gson();
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(BusinessUserController.class);

    @Autowired
    private BusinessUserService businessUserService;
    @Autowired
    private BusinessUserDao businessUserDao;
    @Autowired
    private RequestUtils requestUtils;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    String registerUser(HttpServletRequest request, HttpServletResponse response) {
        BusinessUserBean businessUserBean = new BusinessUserBean(request);
        if (businessUserBean.isValidUser()) {
            logger.info("User : " + businessUserBean.getUserName() + " is registered successfully");
            businessUserService.setCookie(response, businessUserBean);
            businessUserService.insertUserDetails(businessUserBean);
            return "{\"businessUserStatus\": \"true\"}";
        } else {
            return "{\"businessUserStatus\": \"false\"}";
        }
    }

    @RequestMapping(value = "getUserDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getUserDetails(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "ssoToken");
        BusinessUser businessUser = businessUserDao.getBusinessUserDetailsBySSOToken(ssoToken);
        if (businessUser != null) {
            return gson.toJson(businessUser);
        }
        return "{\"userStatus\": \"false\"}";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    Boolean doLogin(HttpServletRequest request, HttpServletRequest response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (businessUserService.isValidUser(userName, password)) {
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
