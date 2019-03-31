package com.phantom.order.controller;

import com.phantom.business.user.service.BusinessUserService;
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

    @Autowired private OrderService orderService;
    @Autowired private BusinessUserService businessUserService;

    @RequestMapping(value = "getStatus", method = RequestMethod.GET)
    public @ResponseBody
    String getStatus(HttpServletRequest request, HttpServletResponse response){
        String orderId = request.getParameter("orderId");
        String ssoToken = RequestUtils.getCookie(request,"ssoToken");
        return orderService.getStatus(orderId,ssoToken);
    }

    @RequestMapping(value = "updateStatus", method = RequestMethod.GET)
    public @ResponseBody
    String updateStatus(HttpServletRequest request, HttpServletResponse response){
        String orderId = request.getParameter("orderId");
        String pickUpOrderStatus = request.getParameter("status");
        String bssoToken = RequestUtils.getCookie(request,"bssoToken");
        return orderService.updateStatus(orderId,bssoToken, pickUpOrderStatus);
    }

    @RequestMapping(value = "user/myOrders", method = RequestMethod.GET)
    public @ResponseBody
    String getMyOrdersForUser (HttpServletRequest request, HttpServletResponse response){
        String ssoToken = RequestUtils.getCookie(request,"ssoToken");
        return orderService.getMyOrdersForUser(ssoToken);
    }

    @RequestMapping(value = "disp/myOrders", method = RequestMethod.GET)
    public @ResponseBody
    String getMyOrdersForDisp (HttpServletRequest request, HttpServletResponse response){
        int dispId = businessUserService.getBusinessUserId(RequestUtils.getCookie(request,"bssoToken")) ;
        return orderService.getMyOrdersForDisp(dispId);
    }

    @RequestMapping(value = "getOrder", method = RequestMethod.GET)
    public @ResponseBody
    String getOrder(HttpServletRequest request, HttpServletResponse response){
        String orderId = request.getParameter("orderId");
        String bssoToken = RequestUtils.getCookie(request,"bssoToken");
        return orderService.getOrder(orderId,bssoToken);
    }

    @RequestMapping(value = "updatePickUpDate", method = RequestMethod.GET)
    public @ResponseBody
    String updatePickUpDate(HttpServletRequest request, HttpServletResponse response){
        String orderId = request.getParameter("orderId");
        String pickUpDate = request.getParameter("pickUpDate");
        String bssoToken = RequestUtils.getCookie(request,"bssoToken");
        return orderService.updatePickUpDate(orderId,bssoToken,pickUpDate);
    }

    @RequestMapping(value = "updatePickUpTimeSlot", method = RequestMethod.GET)
    public @ResponseBody
    String updatePickUpTimeSlot(HttpServletRequest request, HttpServletResponse response){
        String orderId = request.getParameter("orderId");
        String timeSlot = request.getParameter("timeSlot");
        String bssoToken = RequestUtils.getCookie(request,"bssoToken");
        return orderService.updatePickUpTimeSlot(orderId,bssoToken,timeSlot);
    }

}
