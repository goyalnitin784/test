package com.phantom.order.service;

import com.google.gson.Gson;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DispensaryPickUpOrderDao;
import com.phantom.model.entity.DispensaryPickUpOrder;
import com.phantom.model.entity.User;
import com.phantom.user.service.UserService;
import com.phantom.util.PhantomUtil;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    PhantomLogger logger = PhantomLogger.getLoggerObject(OrderService.class);
    private final static Gson gson = new Gson();
    @Autowired
    private DispensaryPickUpOrderDao dispensaryPickUpOrderDao;
    @Autowired
    private UserService userService;

    public String getStatus(String id, String ssoToken) {
        String code = "200";
        String msg = "";
        try {
            if (PhantomUtil.isNullOrEmpty(id)) {
                code = "404";
                msg = "Order Id is not present in request";
            } else if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                code = "404";
                msg = "User not logged in";
            } else {
                Long orderId = Long.parseLong(id);
                msg = dispensaryPickUpOrderDao.getStatus(orderId);
            }

            if (PhantomUtil.isNullOrEmpty(msg)) {
                code = "500";
                msg = "Order Status Not Found";
            }
        } catch (Exception e) {
            logger.error("Exception Occurred while finding status for order id : " + id, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String getMyOrdersForUser(String ssoToken) {
        String code = "200";
        String msg = "";
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                code = "404";
                msg = "User not logged in";
            } else {
                User user = userService.getUserDetails(ssoToken);
                if (user == null) {
                    code = "404";
                    msg = "User not logged in";
                } else {
                    List<DispensaryPickUpOrder> dispensaryPickUpOrders = dispensaryPickUpOrderDao.getOrdersByUserId((int) user.getUserId());
                    msg = gson.toJson(dispensaryPickUpOrders);
                }
            }

            if (PhantomUtil.isNullOrEmpty(msg)) {
                code = "500";
                msg = "My Orders Not Found";
            }
        } catch (Exception e) {
            logger.error("Exception Occurred while finding my orders ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String getMyOrdersForDisp(String dispId) {
        String code = "200";
        String msg = "" ;
        try {
            if (PhantomUtil.isNullOrEmpty(dispId)) {
                code = "404";
                msg = "Dispensary Id is not present in request";
            } else {
                List<DispensaryPickUpOrder> dispensaryPickUpOrders = dispensaryPickUpOrderDao.getOrdersByDispId(Integer.parseInt(dispId));
                msg = gson.toJson(dispensaryPickUpOrders);
            }
            if (PhantomUtil.isNullOrEmpty(msg)) {
                code = "500";
                msg = "My Orders Not Found";
            }
        } catch (Exception e) {
            logger.error("Exception Occurred while finding my orders ", e);
            msg = e.getMessage();
            code = "500";
        }

        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }
}
