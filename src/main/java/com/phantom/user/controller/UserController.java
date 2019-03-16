package com.phantom.user.controller;

import com.phantom.logging.PhantomLogger;
import com.phantom.model.entity.User;
import com.phantom.user.request.UserBean;
import com.phantom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "user")
public class UserController {
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(UserController.class);

    @Autowired private UserService userService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody String registerUser(HttpServletRequest request, HttpServletResponse response){
        UserBean userBean = new UserBean(request);
        if(userBean.isValidUser()) {
            logger.info("User : " + userBean.getUserName() + " is registered successfully");
            userService.setCookie(response,userBean);

            //TODO insert user details and user_id & sso tokrn mapping in tables

            return "{\"userStatus\": \"true\"}";
        }else{
            return "{\"userStatus\": \"false\"}";
        }
    }

    @RequestMapping(value = "getUserDetails", method = RequestMethod.GET)
    public @ResponseBody String getUserDetails(@RequestParam String userId){
        User user = userService.getUserDetails(userId);
        return null;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody Boolean doLogin(HttpServletRequest request,HttpServletRequest response){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if(userService.isValidUser(userName,password)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
