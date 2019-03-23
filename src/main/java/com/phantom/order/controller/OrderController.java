package com.phantom.order.controller;

import com.phantom.order.service.OrderService;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "order")
public class OrderController {
    private RequestUtils requestUtils;

    @Autowired private OrderService orderService;

    @RequestMapping(value = "getStatus", method = RequestMethod.GET)
    public @ResponseBody
    String getStatus(HttpServletRequest request, HttpServletResponse response){
        String orderId = request.getParameter("orderId");
        String ssoToken = requestUtils.getCookieValue(request,"ssoToken");
        return orderService.getStatus(orderId,ssoToken);
    }

    @RequestMapping(value = "user/myOrders", method = RequestMethod.GET)
    public @ResponseBody
    String getMyOrdersForUser (HttpServletRequest request, HttpServletResponse response){
        String ssoToken = requestUtils.getCookieValue(request,"ssoToken");
        return orderService.getMyOrdersForUser(ssoToken);
    }

    @RequestMapping(value = "disp/myOrders", method = RequestMethod.GET)
    public @ResponseBody
    String getMyOrdersForDisp (HttpServletRequest request, HttpServletResponse response){
        String dispId = request.getParameter("dispId");
        return orderService.getMyOrdersForDisp(dispId);
    }
}
