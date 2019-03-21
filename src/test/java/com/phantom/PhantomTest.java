package com.phantom;

import com.phantom.dispensary.request.DispensaryBean;
import com.phantom.dispensary.service.DispensaryService;
import com.phantom.model.dao.UserDao;
import com.phantom.user.request.UserBean;
import com.phantom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Test
@ContextConfiguration(locations = {"classpath:spring/spring-core-config.xml"})
public class PhantomTest extends AbstractTestNGSpringContextTests {

    @Autowired
    UserDao userDao;

    @Autowired private UserService userService;
    @Autowired private DispensaryService dispensaryService;

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
    public void findD(){
        String output = dispensaryService.find("19.171961","72.872726");
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

    @Test
    public void addDispensary(){
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("dispensaryName","dis1");
            requestMap.put("dispensaryDesc","first dis");
            requestMap.put("phoneNo","73497939329");
            requestMap.put("email","dis1@test.com");
            requestMap.put("website","dis1test.com");
            requestMap.put("address","dis1 address");
            requestMap.put("longitude","-82.334178");
            requestMap.put("latitude","51.433464");
            requestMap.put("city","LA");
            requestMap.put("state","LA");
            requestMap.put("country","USA");
            requestMap.put("facilities","dis1 facilities");
            requestMap.put("timeZone","GMT-5");

            DispensaryBean dispensaryBean = new DispensaryBean(requestMap);
            dispensaryService.addDispensary(dispensaryBean);
        }catch (Exception e){
            logger.error("Exception occurred while testing addDispensary controller ",e);
        }
    }
}
