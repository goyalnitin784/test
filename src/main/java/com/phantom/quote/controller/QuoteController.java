package com.phantom.quote.controller;

import com.phantom.quote.request.QuoteRequest;
import com.phantom.quote.service.QService;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class QuoteController {

    @Autowired
    QService qService;

    @RequestMapping(value = "getQuote", method = RequestMethod.POST)
    public @ResponseBody
    String getQuote(HttpServletRequest request, HttpServletResponse response) {
        QuoteRequest quoteRequest = new QuoteRequest(request);
        String ssotoken = RequestUtils.getCookie(request,"ssoToken");
        quoteRequest.setSsoToken(ssotoken);
        return qService.getQuote(quoteRequest);
    }

}
