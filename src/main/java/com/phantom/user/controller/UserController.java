package com.phantom.user.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.phantom.business.user.service.BusinessUserService;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.UserDao;
import com.phantom.model.dao.UserSSOTokenMappingDao;
import com.phantom.model.entity.User;
import com.phantom.quote.service.QService;
import com.phantom.user.request.DealReviewBean;
import com.phantom.user.request.UserBean;
import com.phantom.user.service.UserService;
import com.phantom.util.PhantomUtil;
import com.phantom.util.RequestUtils;
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
    @Autowired
    private BusinessUserService businessUserService;


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    String registerUser(HttpServletRequest request, HttpServletResponse response) {
        UserBean userBean = new UserBean(request);
        userService.setCookie(response, userBean.getUserName(), userBean.getSsoToken());
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
        String code = "200";
        String msg = "SUCCESS";
        JsonElement res = null;

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = userService.isValidUser(userName, password, email);
        if (user != null) {
            res = gson.toJsonTree(user);
            String ssoToken = UUID.randomUUID().toString();
            userService.setCookie(response, userName, ssoToken);
            userService.setSSOToken(user.getUserId(), user.getUserName(), ssoToken);
        } else {
            code = "500";
            msg = "FAILED";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(res);
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
        return qService.getUserQuote(RequestUtils.getCookie(request, "ssoToken"));
    }

    @RequestMapping(value = "dealReview", method = RequestMethod.POST)
    public @ResponseBody
    String giveDealReview(HttpServletRequest request, HttpServletResponse response) {
        DealReviewBean dealReviewBean = new DealReviewBean(request);
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        dealReviewBean.setReviewerUserId(userId);
        return userService.giveDealReview(dealReviewBean);
    }

    @RequestMapping(value = "getAboutMe", method = RequestMethod.GET)
    public @ResponseBody
    String getAboutMe(HttpServletRequest request, HttpServletResponse response) {
        return userService.getAboutMe(requestUtils.getCookieValue(request, "ssoToken"));
    }

    @RequestMapping(value = "addAboutMe", method = RequestMethod.POST)
    public @ResponseBody
    String addAboutMe(HttpServletRequest request, HttpServletResponse response) {
        return userService.addAboutMe(requestUtils.getCookieValue(request, "ssoToken"), request.getParameter("aboutMe"));
    }

    @RequestMapping(value = "addExperience", method = RequestMethod.POST)
    public @ResponseBody
    String addExperience(HttpServletRequest request, HttpServletResponse response) {
        return userService.addExperience(requestUtils.getCookieValue(request, "ssoToken"), request.getParameter("experience"));
    }

    @RequestMapping(value = "addProfilePic", method = RequestMethod.GET)
    public @ResponseBody
    String addProfilePic(HttpServletRequest request, HttpServletResponse response) {
        return userService.addProfilePic(requestUtils.getCookieValue(request, "ssoToken"), request.getParameter("picPath"));
    }

    @RequestMapping(value = "getMyQuotesList", method = RequestMethod.GET)
    public @ResponseBody
    String getMyQuotesList(HttpServletRequest request, HttpServletResponse response) {
        return userService.addProfilePic(requestUtils.getCookieValue(request, "ssoToken"), request.getParameter("picPath"));
    }

    @RequestMapping(value = "getListofMypics", method = RequestMethod.GET)
    public @ResponseBody
    String getListofMypics(HttpServletRequest request, HttpServletResponse response) {
        return userService.getListofMypics(requestUtils.getCookieValue(request, "ssoToken"));
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public @ResponseBody
    String changePassword(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(requestUtils.getCookieValue(request, "ssoToken"));
        return userService.changePassword(userId, request.getParameter("password"));
    }

    @RequestMapping(value = "changePhoneNo", method = RequestMethod.POST)
    public @ResponseBody
    String changePhoneNo(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(requestUtils.getCookieValue(request, "ssoToken"));
        return userService.changePhoneNo(userId, request.getParameter("phone"));
    }
}
