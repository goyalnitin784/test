package com.phantom.user.service;

import com.phantom.model.entity.User;
import com.phantom.user.request.UserBean;
import com.phantom.util.RequestUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

@Service
public class UserService {
    @Autowired private RequestUtils requestUtils;

    public void setCookie(HttpServletResponse response, UserBean userBean){
        if(userBean.isValidUser()) {
            requestUtils.addCookie(response, "userName", userBean.getUserName());
            requestUtils.addCookie(response, "ssoToken", userBean.getSsoToken());
        }
    }

    public User getUserDetails(String id){
        Long userId = Long.parseLong(id);
        User user = null;
        // TODO return user model from db using user id
        return user;
    }

    public Boolean isValidUser(String userName,String password){
        if(!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)){
            // TODO check user name and password mapping to validate
            if(true){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
