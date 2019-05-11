package com.airtel.controller;

import com.airtel.model.dao.TestDao;
import com.airtel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HealthCheckController {

    @Autowired
    TestService testService;

    @Autowired
    TestDao testDao;

    @Autowired
    @Qualifier("testThreadPoolExecutor")
    ThreadPoolTaskExecutor threadPoolTaskExecutor;


    @ResponseBody
    @RequestMapping(value = "/health-check", method = RequestMethod.GET)
    public String healthCheck(HttpServletRequest request) {
        testService.log();
        testDao.test();
        return "{}";
    }

}
