package com.phantom.user.controller;

import com.google.gson.Gson;
import com.phantom.business.user.request.BusinessUserBean;
import com.phantom.business.user.service.BusinessUserService;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.UserDao;
import com.phantom.model.dao.UserSSOTokenMappingDao;
import com.phantom.model.entity.User;
import com.phantom.model.entity.UserSSOTokenMapping;
import com.phantom.quote.service.QService;
import com.phantom.response.GenericResponse;
import com.phantom.user.request.DealReviewBean;
import com.phantom.user.request.UserBean;
import com.phantom.user.service.UserService;
import com.phantom.util.RequestUtils;
import com.phantom.util.UserKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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
    @Autowired
    private UserSSOTokenMappingDao userSSOTokenMappingDao;

    @Autowired
    QService qService;
    @Autowired private BusinessUserService businessUserService;


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    String registerUser(HttpServletRequest request, HttpServletResponse response) {
        UserBean userBean = new UserBean(request);
        businessUserService.setCookie(response, userBean.getUserName(), userBean.getSsoToken());
        return userService.insertUserDetails(userBean);
    }

    @RequestMapping(value = "getUserDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getUserDetails(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "ssoToken");
        return userService.getUserDetailsAsJson(ssoToken);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    String doLogin(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.isValidUser(userName, password);
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (user != null) {
            String ssoToken = UUID.randomUUID().toString();
            userService.setCookie(response, userName, ssoToken);
            userService.setSSOToken(user.getUserId(), user.getUserName(), ssoToken);
            baseResponseDTO.setCode("200");
            baseResponseDTO.addMessage("SUCCESS");
        } else {
            baseResponseDTO.setCode("500");
            baseResponseDTO.addMessage("FAILED");
        }
        return gson.toJson(baseResponseDTO);
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public @ResponseBody
    String logout(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "ssoToken");
        return userService.logout(ssoToken);
    }

    @RequestMapping(value = "getQuote", method = RequestMethod.POST)
    public @ResponseBody
    String getQuote(HttpServletRequest request, HttpServletResponse response) {
        return qService.getUserQuote(RequestUtils.getCookie(request,"ssoToken"));
    }

    @RequestMapping(value = "dealReview", method = RequestMethod.POST)
    public @ResponseBody
    String giveDealReview(HttpServletRequest request, HttpServletResponse response) {
        DealReviewBean dealReviewBean = new DealReviewBean(request);
        int userId = userService.getUserId(RequestUtils.getCookie(request,"ssoToken"));
        dealReviewBean.setReviewerUserId(userId);
        return userService.giveDealReview(dealReviewBean);
    }
}
