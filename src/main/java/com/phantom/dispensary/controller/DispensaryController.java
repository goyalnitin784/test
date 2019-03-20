package com.phantom.dispensary.controller;

import com.phantom.dispensary.service.DispensaryService;
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

    @RequestMapping(value = "getProductList", method = RequestMethod.POST)
    public @ResponseBody
    String getProductList(HttpServletRequest request, HttpServletResponse response) {
        return dispensaryService.getProductList();
    }

}
