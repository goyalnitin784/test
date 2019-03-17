package com.phantom;

import com.phantom.model.dao.UserDao;
import com.phantom.user.request.UserBean;
import com.phantom.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.StringUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Test
@ContextConfiguration(locations = {"classpath:spring/spring-core-config.xml"})
public class PhantomTest extends AbstractTestNGSpringContextTests {

    @Autowired
    UserDao userDao;

    @Autowired private UserService userService;

    @Test
    public void sampleTest() throws Exception {
        System.out.println("Context up");
        try{
            userDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void registrationTest(){
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("userType", "0");
            requestMap.put("title", "Mr.");
            requestMap.put("firstName", "Vijay");
            requestMap.put("lastName", "Saini");
            requestMap.put("userName", "imvk");
            requestMap.put("password", "123456");
            requestMap.put("phoneNo", "8954590099");
            requestMap.put("email", "abc@gmail.com");
            requestMap.put("dob", "1997-07-20");
            UserBean userBean = new UserBean(requestMap);
            userService.insertUserDetails(userBean);
        }catch (Exception e){
            logger.error("Exception occurred while testing registration controller ",e);
        }
    }

    @Test
    public void loginTest(){
        try {
            String userName = "imvk";
            String password = "123456";
            if(!StringUtils.isEmpty(userService.isValidUser(userName,password))){
                Reporter.log("Successfully login");
            }else{
                Reporter.log("Login Failed");
            }
        }catch (Exception e){
            logger.error("Exception in login test ",e);
        }
    }

}
