package com.phantom;

import com.phantom.business.user.request.BusinessUserBean;
import com.phantom.business.user.service.BusinessUserService;
import com.phantom.dispensary.request.*;
import com.phantom.dispensary.service.DispensaryService;
import com.phantom.model.dao.UserDao;
import com.phantom.order.service.OrderService;
import com.phantom.user.request.DealReviewBean;
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
    private BusinessUserService businessUserService;
    @Autowired
    private DispensaryService dispensaryService;
    @Autowired
    private OrderService orderService;

    @Test
    public void healthCheckTest() throws Exception {
        System.out.println("Context up");
        try {
            userDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public String registrationTest() {
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("userType", "0");
            requestMap.put("userName", "phantom");
            requestMap.put("password", "Phantom1!3#2@");
            requestMap.put("phoneNo", "0987654321");
            requestMap.put("email", "phantom@phantom.com");
            requestMap.put("dob", "1995-03-16");
            UserBean userBean = new UserBean(requestMap);
            return userService.insertUserDetails(userBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing registration controller ", e);
        }
        return null;
    }

    @Test
    public String businessRegistrationTest() {
        Map<String, String> requestMap = new HashMap<>();
        try {
            requestMap.put("userType", "0");
            requestMap.put("userName", "phantom");
            requestMap.put("password", "Phantom1!3#2@");
            requestMap.put("phoneNo", "0987654321");
            requestMap.put("email", "phantom@phantom.com");
            requestMap.put("dob", "1995-03-16");
            requestMap.put("dispensaryId", "3");
            BusinessUserBean businessUserBean = new BusinessUserBean(requestMap);
            return businessUserService.insertUserDetails(businessUserBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing registration controller ", e);
        }
        return null;
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
            dispensaryService.updateDispensaryDetails(dispensaryBean);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispensary controller ", e);
        }
    }

    @Test
    public void findD() {
        String output = dispensaryService.find("19.171961", "72.872726");
    }


    @Test
    public String addDispensaryReview() {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("dispId", "3");
        requestMap.put("reviewerUserId", "7");
        requestMap.put("serviceRating", "3");
        requestMap.put("atmosphereRating", "5");
        requestMap.put("qualityRating", "4");
        requestMap.put("reviewDesc", "It was good");

        DispReviewBean dispReviewBean = new DispReviewBean(requestMap);
        return dispensaryService.addReviewForDispensary(dispReviewBean);
    }

    @Test
    public String addDispensaryDeals() {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("dispId", "3");
        requestMap.put("isActive", "1");
        requestMap.put("dealName", "Phantom Deal");
        requestMap.put("dealDesc", "Buy one get one free");
        requestMap.put("voucherCode", "PHANTOM");
        requestMap.put("dealTagLine", "it's here");
        requestMap.put("price", "50");

        DispDealsBean dispDealsBean = new DispDealsBean(requestMap);
        return dispensaryService.addDeals(dispDealsBean);

    }

    @Test
    public String addDispFollowers() {
        String dispensaryId = "3";
        int userId = 7;
        return dispensaryService.followDispensary(dispensaryId, userId);

    }

    @Test
    public String addDispGallery() {
        int dispensaryId = 3;
        String picPath = "x/y/z";
        return dispensaryService.updateDispGallery(dispensaryId, picPath);
    }

    @Test
    public String addDispMenu() {
        Map<String, String> requestMap = new HashMap<>();
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
        return dispensaryService.addMenu(dispMenuBean);

    }

    @Test
    public void addDispMenuPrice() {
        try {
            String dispMenuId = "1";
            String productPrice = "50";
            String quantity = "10";
            String currency = "$";

            dispensaryService.updateDispensaryMenuPrice(dispMenuId, productPrice, quantity, currency);
        } catch (Exception e) {
            logger.error("Exception occurred while testing addDispMenuPrice controller ", e);
        }
    }

    @Test
    public String placeOrder() {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("dispId", "3");
        requestMap.put("userId", "7");
        requestMap.put("dispPickUpOrderCode", "Test");
        requestMap.put("pickUpDate", "2019-03-22");
        requestMap.put("totalCost", "150");

        DispPickUpOrderBean dispPickUpOrderBean = new DispPickUpOrderBean(requestMap);
        return dispensaryService.placeOrder(dispPickUpOrderBean);

    }

    @Test
    public String addDispOrderDetails() {
        String dispOrderId = "1";
        String price = "50";
        String quantity = "10";
        String strainName = "phantom";

        return dispensaryService.updateDispPickUpOrderDetails(dispOrderId, price, quantity, strainName);
    }

    @Test
    public String addDispensaryUpdates() {
        int dispId = 3;
        String dispUpdates = "new arrivals";
        return dispensaryService.updates(dispId, dispUpdates);
    }

    @Test
    public String myOrdersForUser() {
        String ssoToken = "7ba6b0d1-4798-4954-b014-9ce6d230e571";
        return orderService.getMyOrdersForUser(ssoToken);
    }

    @Test
    public String myOrdersForDisp() {
        int dispId = 3;
        return orderService.getMyOrdersForDisp(dispId);
    }

    @Test
    public String giveDealReview() {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("dispId", "3");
        requestMap.put("dealId", "1");
        requestMap.put("overAllRating", "2");
        requestMap.put("qualityRating", "4");
        requestMap.put("recommendationCount", "2");
        requestMap.put("isReviewHelpfulCount", "1");
        requestMap.put("sharesCount", "2");
        requestMap.put("reviewDesc", "It was good");
        requestMap.put("valueForMoneyRating", "4");
        requestMap.put("dealCorrectnessRating", "3");
        requestMap.put("recommendForFuture", "2");

        DealReviewBean dealReviewBean = new DealReviewBean(requestMap);
        return userService.giveDealReview(dealReviewBean);
    }
}
