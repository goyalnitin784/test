package com.phantom.dispensary.controller;

import com.google.gson.Gson;
import com.phantom.business.user.service.BusinessUserService;
import com.phantom.dispensary.request.*;
import com.phantom.dispensary.service.DealService;
import com.phantom.dispensary.service.DispensaryService;
import com.phantom.logging.PhantomLogger;
import com.phantom.user.service.UserService;
import com.phantom.util.RequestUtils;
import com.phantom.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DispensaryController {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(DispensaryController.class);

    @Autowired
    private DispensaryService dispensaryService;
    private final static Gson gson = new Gson();
    @Autowired
    private UserService userService;
    @Autowired
    private BusinessUserService businessUserService;
    @Autowired private DealService dealService;

    @RequestMapping(value = "getProductList", method = RequestMethod.POST)
    public @ResponseBody
    String getProductList(HttpServletRequest request, HttpServletResponse response) {
        return dispensaryService.getProductList();
    }

    @RequestMapping(value = "updateDispensaryDetails", method = RequestMethod.POST)
    public @ResponseBody
    String addDispensary(HttpServletRequest request, HttpServletResponse response) {
        DispensaryBean dispensaryBean = new DispensaryBean(request);
        boolean isUpdated = false;
        if (dispensaryBean.isValidDispensary()) {
            isUpdated = dispensaryService.updateDispensaryDetails(dispensaryBean);
        }
        return new ResponseUtils().getResponseByFlag(isUpdated);
    }

    @RequestMapping(value = "findDispensary", method = RequestMethod.GET)
    public @ResponseBody
    String findDispensary(HttpServletRequest request, HttpServletResponse response) {
        return dispensaryService.findDispensary(request.getParameter("lat"), request.getParameter("long"),
                request.getParameter("records"),false);
    }

    @RequestMapping(value = "findFeaturedDispensary", method = RequestMethod.GET)
    public @ResponseBody
    String findFeaturedDispensary(HttpServletRequest request, HttpServletResponse response) {
        return dispensaryService.findDispensary(request.getParameter("lat"), request.getParameter("long"),
                request.getParameter("records"),true);
    }

    @RequestMapping(value = "addReviewForDispensary", method = RequestMethod.POST)
    public @ResponseBody
    String reviewDispensary(HttpServletRequest request, HttpServletResponse response) {
        DispReviewBean dispReviewBean = new DispReviewBean(request);
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        dispReviewBean.setReviewerUserId(userId);
        return dispensaryService.addReviewForDispensary(dispReviewBean);
    }

    @RequestMapping(value = "getDispensaryQuotes", method = RequestMethod.GET)
    public @ResponseBody
    String getDispensaryQuote(HttpServletRequest request, HttpServletResponse response) {
        String token = RequestUtils.getCookie(request, "bssoToken");
        return dispensaryService.getDispensaryQuote(token);
    }

    @RequestMapping(value = "addDispensaryDeals", method = RequestMethod.POST)
    public @ResponseBody
    String addDispensaryDeals(HttpServletRequest request, HttpServletResponse response) {
        DispDealsBean dispDealsBean = new DispDealsBean(request);
        int businessUserId = businessUserService.getBusinessUserId(RequestUtils.getCookie(request, "bssoToken"));
        dispDealsBean.setDispensaryId(businessUserId);
        return dispensaryService.addDeals(dispDealsBean);
    }

    @RequestMapping(value = "followDispensary", method = RequestMethod.GET)
    public @ResponseBody
    String addDispFollowers(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        String dispensaryId = request.getParameter("dispId");
        return dispensaryService.followDispensary(dispensaryId, userId);
    }

    @RequestMapping(value = "updatedispGallery", method = RequestMethod.GET)
    public @ResponseBody
    String addDispGallery(HttpServletRequest request, HttpServletResponse response) {
        int dispensaryId = businessUserService.getBusinessUserId(RequestUtils.getCookie(request, "bssoToken"));
        String picPath = request.getParameter("picPath");
        return dispensaryService.updateDispGallery(dispensaryId, picPath);
    }

    @RequestMapping(value = "addDispensaryMenu", method = RequestMethod.POST)
    public @ResponseBody
    String addDispensaryMenu(HttpServletRequest request, HttpServletResponse response) {
        DispMenuBean dispMenuBean = new DispMenuBean(request);
        int dispensaryId = businessUserService.getBusinessUserId(RequestUtils.getCookie(request, "bssoToken"));
        dispMenuBean.setDispensaryId(dispensaryId);

        return dispensaryService.addMenu(dispMenuBean);
    }

    @RequestMapping(value = "updateDispensaryMenuPrice", method = RequestMethod.POST)
    public @ResponseBody
    String addDispensaryMenuPrice(HttpServletRequest request, HttpServletResponse response) {
        String dispMenuId = request.getParameter("dispMenuId");
        String productPrice = request.getParameter("productPrice");
        String quantity = request.getParameter("quantity");
        String currency = request.getParameter("currency");
        return dispensaryService.updateDispensaryMenuPrice(dispMenuId, productPrice, quantity, currency);
    }

    @RequestMapping(value = "placeOrder", method = RequestMethod.POST)
    public @ResponseBody
    String placeOrder(HttpServletRequest request, HttpServletResponse response) {
        DispPickUpOrderBean dispPickUpOrderBean = new DispPickUpOrderBean(request);
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        dispPickUpOrderBean.setUserId(userId);
        return dispensaryService.placeOrder(dispPickUpOrderBean);
    }

    @RequestMapping(value = "updateDispPickUpOrderDetails", method = RequestMethod.POST)
    public @ResponseBody
    String updateDispPickUpOrderDetails(HttpServletRequest request, HttpServletResponse response) {
        boolean isOrderDetailsAdded = Boolean.FALSE;
        String dispOrderId = request.getParameter("dispOrderId");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String strainName = request.getParameter("strainName");
        return dispensaryService.updateDispPickUpOrderDetails(dispOrderId, price, quantity, strainName);
    }

    @RequestMapping(value = "dispUpdates", method = RequestMethod.POST)
    public @ResponseBody
    String addDispUpdates(HttpServletRequest request, HttpServletResponse response) {
        int dispensaryId = businessUserService.getBusinessUserId(RequestUtils.getCookie(request, "bssoToken"));
        String updateDetails = request.getParameter("updateDetails");
        return dispensaryService.updates(dispensaryId, updateDetails);
    }

    @RequestMapping(value = "isTrendingDispDeal", method = RequestMethod.GET)
    public @ResponseBody String isTrendingDisp(HttpServletRequest request, HttpServletResponse response){
        String dispDealId = request.getParameter("dispDealId");
        return dealService.isTrendingDispDeal(dispDealId);
    }

    @RequestMapping(value = "isFeaturedDespDeal", method = RequestMethod.GET)
    public @ResponseBody String isFeaturedDespDeal(HttpServletRequest request, HttpServletResponse response){
        String dispDealId = request.getParameter("dispDealId");
        return dealService.isFeaturedDespDeal(dispDealId);
    }

    @RequestMapping(value = "followDispDeal", method = RequestMethod.GET)
    public @ResponseBody String followDispDeal(HttpServletRequest request, HttpServletResponse response){
        String dispDealId = request.getParameter("dispDealId");
        return dealService.followDispDeal(dispDealId);
    }

    @RequestMapping(value = "findDeals", method = RequestMethod.GET)
    public @ResponseBody
    String findDeals(HttpServletRequest request, HttpServletResponse response) {
        return dealService.findDealsNearYou(request.getParameter("lat"), request.getParameter("long"),
                request.getParameter("records"),false);
    }

    @RequestMapping(value = "findFeaturedDeals", method = RequestMethod.GET)
    public @ResponseBody
    String findFeaturedDeals(HttpServletRequest request, HttpServletResponse response) {
        return dealService.findDealsNearYou(request.getParameter("lat"), request.getParameter("long"),
                request.getParameter("records"),true);
    }

}
