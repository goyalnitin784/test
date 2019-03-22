package com.phantom;

import com.phantom.dispensary.request.*;
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

    @Autowired
    private UserService userService;
    @Autowired
    private DispensaryService dispensaryService;

    @Test
    public void sampleTest() throws Exception {
        System.out.println("Context up");
        try {
            userDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findD() {
        String output = dispensaryService.find("19.171961", "72.872726");
    }

    @Test
    public void registrationTest() {
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("userType", "0");
            requestMap.put("userName", "phantom");
            requestMap.put("password", "Phantom1!3#2@");
            requestMap.put("phoneNo", "0987654321");
            requestMap.put("email", "phantom@phantom.com");
            requestMap.put("dob", "1995-03-16");
            UserBean userBean = new UserBean(requestMap);
            userService.insertUserDetails(userBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing registration controller ", e);
        }
    }

    @Test
    public void loginTest() {
        try {
            String userName = "imvk";
            String password = "123456";
            if (userService.isValidUser(userName, password) != null) {
                Reporter.log("Successfully login");
            } else {
                Reporter.log("Login Failed");
            }
        } catch (Exception e) {
            logger.error("Exception in login test ", e);
        }
    }

    @Test
    public void addDispensary() {
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("dispensaryName", "dis1");
            requestMap.put("dispensaryDesc", "first dis");
            requestMap.put("phoneNo", "73497939329");
            requestMap.put("email", "dis1@test.com");
            requestMap.put("website", "dis1test.com");
            requestMap.put("address", "dis1 address");
            requestMap.put("longitude", "-82.334178");
            requestMap.put("latitude", "51.433464");
            requestMap.put("city", "LA");
            requestMap.put("state", "LA");
            requestMap.put("country", "USA");
            requestMap.put("facilities", "dis1 facilities");
            requestMap.put("timeZone", "GMT-5");

            DispensaryBean dispensaryBean = new DispensaryBean(requestMap);
            dispensaryService.addDispensary(dispensaryBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensary controller ", e);
        }
    }

    @Test
    public void reviewDispensary() {
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("dispId", "3");
            requestMap.put("reviewerUserId", "7");
            requestMap.put("serviceRating", "3");
            requestMap.put("atmosphereRating", "5");
            requestMap.put("qualityRating", "4");
            requestMap.put("recommendationCount", "2");
            requestMap.put("isReviewHelpfulCount", "1");
            requestMap.put("sharesCount", "2");
            requestMap.put("reviewDesc", "It was good");

            DispReviewBean dispReviewBean = new DispReviewBean(requestMap);
            dispensaryService.review(dispReviewBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensary controller ", e);
        }
    }

    @Test
    public void addDispensaryDeals() {
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("dispId", "3");
            requestMap.put("isActive", "1");
            requestMap.put("dealName", "Phantom Deal");
            requestMap.put("dealDesc", "Buy one get one free");
            requestMap.put("voucherCode", "PHANTOM");
            requestMap.put("dealTagLine", "it's here");
            requestMap.put("followers", "3");
            requestMap.put("price", "50");

            DispDealsBean dispDealsBean = new DispDealsBean(requestMap);
            dispensaryService.addDeals(dispDealsBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensaryDeals controller ", e);
        }
    }

    @Test
    public void addDispFollowers() {
        try {
            int dispensaryId = 3;
            int userId = 7;
            dispensaryService.addDispFollowers(dispensaryId,userId);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensaryDeals controller ", e);
        }
    }

    @Test
    public void addDispGallery() {
        try {
            int dispensaryId = 3;
            int isActive = 1;
            String picPath = "x/y/z";
            dispensaryService.addGallery(dispensaryId,isActive,picPath);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensaryDeals controller ", e);
        }
    }

    @Test
    public void addDispMenu() {
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("dispId", "3");
            requestMap.put("productName", "test");
            requestMap.put("productCatTypeId", "5");
            requestMap.put("strainCatTypeId", "8");
            requestMap.put("strainId", "1");
            requestMap.put("breeder", "test breeder");
            requestMap.put("desc", "its test for test");
            requestMap.put("image1", "image1");
            requestMap.put("image2", "image2");

            DispMenuBean dispMenuBean = new DispMenuBean(requestMap);
            dispensaryService.addMenu(dispMenuBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensaryDeals controller ", e);
        }
    }

    @Test
    public void addDispMenuPrice() {
        try {
            int dispMenuId = 1;
            String productPrice = "50";
            String quantity = "10";
            String currency = "$";

            dispensaryService.addMenuPrice(dispMenuId,productPrice,quantity,currency);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensaryDeals controller ", e);
        }
    }

    @Test
    public void addDispPickUpOrder() {
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("dispId", "3");
            requestMap.put("userId", "7");
            requestMap.put("dispPickUpOrderCode", "Test");
            requestMap.put("pickUpDate", "2019-03-22");
            requestMap.put("totalCost", "150");

            DispPickUpOrderBean dispPickUpOrderBean = new DispPickUpOrderBean(requestMap);
            dispensaryService.addPickUpOrder(dispPickUpOrderBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensaryDeals controller ", e);
        }
    }

    @Test
    public void addDispOrderDetails() {
        try {
            int dispOrderId = 1;
            int price = 50;
            int quantity = 10;
            String strainName = "phantom";

            dispensaryService.addPickUpOrderDetails(dispOrderId,price,quantity,strainName);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensaryDeals controller ", e);
        }
    }
}
