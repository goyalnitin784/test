package com.phantom.dispensary.controller;

import com.google.gson.Gson;
import com.phantom.dispensary.request.DispDealsBean;
import com.phantom.dispensary.request.DispReviewBean;
import com.phantom.dispensary.request.DispensaryBean;
import com.phantom.dispensary.service.DispensaryService;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DispensaryController {

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
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (isRegistered) {
            baseResponseDTO.addMessage("SUCCESS");
            baseResponseDTO.setCode("200");
        } else {
            baseResponseDTO.addMessage("FAILURE");
            baseResponseDTO.setCode("500");
        }
        return gson.toJson(baseResponseDTO);
    }

    @RequestMapping(value = "findDispensary", method = RequestMethod.GET)
    public @ResponseBody
    String findDispensary(HttpServletRequest request, HttpServletResponse response) {
        return dispensaryService.find(request.getParameter("lat"), request.getParameter("long"));
    }

    @RequestMapping(value = "reviewDispensary", method = RequestMethod.GET)
    public @ResponseBody
    String reviewDispensary(HttpServletRequest request, HttpServletResponse response){
        DispReviewBean dispReviewBean = new DispReviewBean(request);
        boolean isReviewed = false;
        if(dispReviewBean.isValidReview()){
           isReviewed = dispensaryService.review(dispReviewBean);
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (isReviewed) {
            baseResponseDTO.addMessage("SUCCESS");
            baseResponseDTO.setCode("200");
        } else {
            baseResponseDTO.addMessage("FAILURE");
            baseResponseDTO.setCode("500");
        }
        return gson.toJson(baseResponseDTO);
    }

    @RequestMapping(value = "getDispensaryQuotes", method = RequestMethod.GET)
    public @ResponseBody
    String getDispensaryQuote(HttpServletRequest request, HttpServletResponse response) {
        String token = RequestUtils.getCookie(request,"bssoToken");
        return dispensaryService.getDispensaryQuote(token);
    }

    @RequestMapping(value = "dispensaryDeals", method = RequestMethod.GET)
    public @ResponseBody
    String addDispensaryDeals(HttpServletRequest request, HttpServletResponse response){
        DispDealsBean dispDealsBean = new DispDealsBean(request);
        boolean isDealAdded = false;
        if(dispDealsBean.isValidDeal()){
            isDealAdded = dispensaryService.addDeals(dispDealsBean);
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        if (isDealAdded) {
            baseResponseDTO.addMessage("SUCCESS");
            baseResponseDTO.setCode("200");
        } else {
            baseResponseDTO.addMessage("FAILURE");
            baseResponseDTO.setCode("500");
        }
        return gson.toJson(baseResponseDTO);
    }

}
