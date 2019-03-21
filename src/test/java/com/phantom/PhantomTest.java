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
            requestMap.put("userType", "1");
            requestMap.put("userName", "yoyo");
            requestMap.put("password", "pass");
            requestMap.put("phoneNo", "8954390099");
            requestMap.put("email", "abcde@gmail.com");
            requestMap.put("dob", "1996-03-16");
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
            if(userService.isValidUser(userName,password) != null){
                Reporter.log("Successfully login");
            }else{
                Reporter.log("Login Failed");
            }
        }catch (Exception e){
            logger.error("Exception in login test ",e);
        }
    }

}
