package com.phantom.user.service;

import com.phantom.user.request.UserBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserValidateService {
    private static final Logger logger = Logger.getLogger(UserValidateService.class);
    public boolean validateUser(UserBean user){
        try{

        }catch (Exception e){
            logger.error("Exception occurred while validating user for user id : ");
        }
        return false;
    }
}
