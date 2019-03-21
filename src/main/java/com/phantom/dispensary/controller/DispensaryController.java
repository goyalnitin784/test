package com.phantom.dispensary.controller;

import com.google.gson.Gson;
import com.phantom.dispensary.request.DispDealsBean;
import com.phantom.dispensary.request.DispMenuBean;
import com.phantom.dispensary.request.DispReviewBean;
import com.phantom.dispensary.request.DispensaryBean;
import com.phantom.dispensary.service.DispensaryService;
import com.phantom.logging.PhantomLogger;
import com.phantom.util.RequestUtils;
import com.phantom.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DispensaryController {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(DispensaryController.class);

    @Autowired
    DispensaryService dispensaryService;
    private final static Gson gson = new Gson();

    @RequestMapping(value = "getProductList", method = RequestMethod.POST)
    public @ResponseBody
    String getProductList(HttpServletRequest request, HttpServletResponse response) {
        return dispensaryService.getProductList();
    }

    @RequestMapping(value = "addDispensary", method = RequestMethod.POST)
    public @ResponseBody
    String addDispensary(HttpServletRequest request, HttpServletResponse response) {
        DispensaryBean dispensaryBean = new DispensaryBean(request);
        boolean isRegistered = false;
        if (dispensaryBean.isValidDispensary()) {
            isRegistered = dispensaryService.addDispensary(dispensaryBean);
        }
        return new ResponseUtils().getResponseByFlag(isRegistered);
    }

    @RequestMapping(value = "findDispensary", method = RequestMethod.GET)
    public @ResponseBody
    String findDispensary(HttpServletRequest request, HttpServletResponse response) {
        return dispensaryService.find(request.getParameter("lat"), request.getParameter("long"));
    }

    @RequestMapping(value = "reviewDispensary", method = RequestMethod.GET)
    public @ResponseBody
    String reviewDispensary(HttpServletRequest request, HttpServletResponse response) {
        DispReviewBean dispReviewBean = new DispReviewBean(request);
        boolean isReviewed = false;
        if (dispReviewBean.isValidReview()) {
            isReviewed = dispensaryService.review(dispReviewBean);
        }
        return new ResponseUtils().getResponseByFlag(isReviewed);
    }

    @RequestMapping(value = "getDispensaryQuotes", method = RequestMethod.GET)
    public @ResponseBody
    String getDispensaryQuote(HttpServletRequest request, HttpServletResponse response) {
        String token = RequestUtils.getCookie(request, "bssoToken");
        return dispensaryService.getDispensaryQuote(token);
    }

    @RequestMapping(value = "dispensaryDeals", method = RequestMethod.GET)
    public @ResponseBody
    String addDispensaryDeals(HttpServletRequest request, HttpServletResponse response) {
        DispDealsBean dispDealsBean = new DispDealsBean(request);
        boolean isDealAdded = false;
        if (dispDealsBean.isValidDeal()) {
            isDealAdded = dispensaryService.addDeals(dispDealsBean);
        }
        return new ResponseUtils().getResponseByFlag(isDealAdded);
    }

    @RequestMapping(value = "addDispFollowers", method = RequestMethod.GET)
    public @ResponseBody
    String addDispFollowers(HttpServletRequest request, HttpServletResponse response) {
        String dispensaryId = request.getParameter("dispId");
        String userId = request.getParameter("userId");
        boolean isFollowerAdded = Boolean.FALSE;
        if (!StringUtils.isEmpty(dispensaryId) && !StringUtils.isEmpty(userId)) {
            isFollowerAdded = dispensaryService.addDispFollowers(Integer.parseInt(dispensaryId), Integer.parseInt(userId));
        }
        return new ResponseUtils().getResponseByFlag(isFollowerAdded);
    }

    @RequestMapping(value = "dispGallery", method = RequestMethod.GET)
    public @ResponseBody
    String addDispGallery(HttpServletRequest request, HttpServletResponse response) {
        boolean isGalleryAdded = Boolean.FALSE;
        try {
            int dispensaryId = Integer.parseInt(request.getParameter("dispId"));
            String picPath = request.getParameter("picPath");
            int isActive = Integer.parseInt(request.getParameter("isActive") != null ? request.getParameter("isActive") : "1");
            if (!StringUtils.isEmpty(picPath)) {
                isGalleryAdded = dispensaryService.addGallery(dispensaryId, isActive, picPath);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while adding dispensary gallery ", e);
            isGalleryAdded = Boolean.FALSE;
        }

        return new ResponseUtils().getResponseByFlag(isGalleryAdded);
    }

    @RequestMapping(value = "dispensaryMenu", method = RequestMethod.POST)
    public @ResponseBody
    String addDispensaryMenu(HttpServletRequest request, HttpServletResponse response) {
        DispMenuBean dispMenuBean = new DispMenuBean(request);
        boolean isMenuAdded = false;
        if (dispMenuBean.isValidMenu()) {
            isMenuAdded = dispensaryService.addMenu(dispMenuBean);
        }
        return new ResponseUtils().getResponseByFlag(isMenuAdded);
    }

}
