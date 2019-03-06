package com.phantom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HealthCheckController {

    @ResponseBody
    @RequestMapping(value = "/health-check", method = RequestMethod.GET)
    public String healthCheck(HttpServletRequest request) {
        return "{}";
    }
}
