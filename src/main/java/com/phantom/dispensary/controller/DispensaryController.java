package com.phantom.dispensary.controller;

import com.google.gson.Gson;
import com.phantom.dispensary.request.DispensaryBean;
import com.phantom.dispensary.service.DispensaryService;
import com.phantom.dto.BaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "user")
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

}
