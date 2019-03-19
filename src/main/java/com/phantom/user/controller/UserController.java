package com.phantom.user.controller;

import com.google.gson.Gson;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.UserDao;
import com.phantom.model.dao.UserSSOTokenMappingDao;
import com.phantom.model.entity.User;
import com.phantom.model.entity.UserSSOTokenMapping;
import com.phantom.response.GenericResponse;
import com.phantom.user.request.UserBean;
import com.phantom.user.service.UserService;
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

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    String registerUser(HttpServletRequest request, HttpServletResponse response) {
        UserBean userBean = new UserBean(request);
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (userBean.isValidUser()) {
            logger.info("User : " + userBean.getUserName() + " is registered successfully");
            userService.setCookie(response, userBean.getUserName(), userBean.getSsoToken());
            userService.insertUserDetails(userBean);
            userService.setSSOToken(userBean.getUserId(), userBean.getUserName(), userBean.getSsoToken());
            baseResponseDTO.setCode("200");
            baseResponseDTO.addMessage("SUCCESS");
        } else {
            baseResponseDTO.setCode("500");
            baseResponseDTO.addMessage("FAILED");
        }
        return baseResponseDTO.toString();
    }

    @RequestMapping(value = "getUserDetails", method = RequestMethod.GET)
    public @ResponseBody
    String getUserDetails(HttpServletRequest request) {
        String ssoToken = requestUtils.getCookieValue(request, "ssoToken");
        User user = userService.getUserDetails(ssoToken);
        GenericResponse genericResponse = new GenericResponse();
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (user != null) {
            baseResponseDTO.setCode("200");
            baseResponseDTO.addMessage("SUCCESS");
            genericResponse.setBaseResponseDTO(baseResponseDTO);
            genericResponse.setResponse(gson.toJson(user));
        } else {
            baseResponseDTO.setCode("500");
            baseResponseDTO.addMessage("FAILED");
            genericResponse.setBaseResponseDTO(baseResponseDTO);
        }
        return genericResponse.toString();
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
        return baseResponseDTO.toString();
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public @ResponseBody
    String logout(HttpServletRequest request) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        try {
            String ssoToken = requestUtils.getCookieValue(request, "ssoToken");
            UserSSOTokenMapping userSSOTokenMapping = userSSOTokenMappingDao.getUserDetailsBySSOToken(ssoToken);
            userSSOTokenMapping.setIsActive(0);
            userSSOTokenMappingDao.saveSSOToken(userSSOTokenMapping);
            baseResponseDTO.setCode("200");
            baseResponseDTO.addMessage("SUCCESS");
        } catch (Exception e) {
            logger.error("Exception occurred while logging out user ", e);
            baseResponseDTO.setCode("500");
            baseResponseDTO.addMessage("FAILED");
            baseResponseDTO.addMessage(e.getMessage());
        }
        return baseResponseDTO.toString();
    }

}
