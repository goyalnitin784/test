package com.airtel.controller;

import com.airtel.context.CallContextKeeper;
import com.airtel.logging.MyLogger;
import com.airtel.request.CommonWordRequest;
import com.airtel.response.CommonWordResponse;
import com.airtel.service.CommonWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CommonWordController {

    @Autowired
    CommonWordService commonWordService;

    MyLogger logger = MyLogger.getLoggerObject(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/get-common-word", method = RequestMethod.POST)
    public String getCommonWord(HttpServletRequest request, HttpServletResponse response) {

        CommonWordRequest commonWordRequest = (CommonWordRequest) CallContextKeeper.getCallContext();
        logger.debug("Request landed successfully on controller with request body : " + commonWordRequest.toString());
        CommonWordResponse commonWordResponse = commonWordService.generateResponse(commonWordRequest);
        response.setStatus(commonWordResponse.getResponseCode());
        return commonWordResponse.getResponse();
    }

}
