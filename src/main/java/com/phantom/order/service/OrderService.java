package com.phantom.order.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DispensaryPickUpOrderDao;
import com.phantom.model.entity.DispensaryPickUpOrder;
import com.phantom.model.entity.User;
import com.phantom.user.service.UserService;
import com.phantom.util.PhantomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    PhantomLogger logger = PhantomLogger.getLoggerObject(OrderService.class);
    private final static Gson gson = new Gson();
    @Autowired
    private DispensaryPickUpOrderDao dispensaryPickUpOrderDao;
    @Autowired
    private UserService userService;

    public String getStatus(String orderId, String ssoToken) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(orderId)) {
                code = "400";
                msg = "Order Id is not present in request";
            } else if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                code = "400";
                msg = "User not logged in";
            } else {
                response = gson.toJsonTree(dispensaryPickUpOrderDao.getStatus(orderId));
            }

            if (response == null) {
                code = "500";
                msg = "Order Status Not Found";
            }
        } catch (Exception e) {
            logger.error("Exception Occurred while finding status for order id : " + orderId, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String getMyOrdersForUser(String ssoToken) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                code = "400";
                msg = "User not logged in";
            } else {
                User user = userService.getUserDetails(ssoToken);
                if (user == null) {
                    code = "400";
                    msg = "User not logged in";
                } else {
                    List<DispensaryPickUpOrder> dispensaryPickUpOrders = dispensaryPickUpOrderDao.getOrdersByUserId((int) user.getUserId());
                    response = gson.toJsonTree(dispensaryPickUpOrders);
                }
            }

            if (response == null) {
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
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String getMyOrdersForDisp(int dispId) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (dispId == -1) {
                code = "400";
                msg = "Business User Not Logged In";
            } else {
                List<DispensaryPickUpOrder> dispensaryPickUpOrders = dispensaryPickUpOrderDao.getOrdersByDispId(dispId);
                response = gson.toJsonTree(dispensaryPickUpOrders);
            }
            if (response == null) {
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
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String updateStatus(String orderId, String bssoToken, String pickUpOrderStatus) {
        String code = "200";
        String msg = "SUCCESS";
        try {
            if (PhantomUtil.isNullOrEmpty(orderId)) {
                code = "400";
                msg = "Order Id is not present in request";
            } else if (PhantomUtil.isNullOrEmpty(bssoToken)) {
                code = "400";
                msg = "Business User not logged in";
            } else if (!dispensaryPickUpOrderDao.updateStatus(orderId, pickUpOrderStatus)) {
                code = "500";
                msg = "Order Status Not Updated";
            }
        } catch (Exception e) {
            logger.error("Exception Occurred while updating status for order id : " + orderId, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String getOrder(String orderId, String bssoToken) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(orderId)) {
                code = "400";
                msg = "Order Id is not present in request";
            } else if (PhantomUtil.isNullOrEmpty(bssoToken)) {
                code = "400";
                msg = "Business User not logged in";
            } else {
                response = gson.toJsonTree(dispensaryPickUpOrderDao.getOrdersByOrderId(orderId));
            }
        } catch (Exception e) {
            logger.error("Exception Occurred while getting order for order id : " + orderId, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String updatePickUpDate(String orderId, String bssoToken, String pickUpDate) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(orderId) || PhantomUtil.isNullOrEmpty(pickUpDate)) {
                code = "400";
                msg = "BAD REQUEST";
            } else if (PhantomUtil.isNullOrEmpty(bssoToken)) {
                code = "400";
                msg = "Business User not logged in";
            } else {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(pickUpDate);
                if(!dispensaryPickUpOrderDao.updatePickUpDate(orderId, date)){
                    code = "500";
                    msg = "FAILED";
                }
            }
        } catch (Exception e) {
            logger.error("Exception Occurred while update order pick up date for order id : " + orderId, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String updatePickUpTimeSlot(String orderId, String bssoToken, String timeSlot) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(orderId) || PhantomUtil.isNullOrEmpty(timeSlot)) {
                code = "400";
                msg = "BAD REQUEST";
            } else if (PhantomUtil.isNullOrEmpty(bssoToken)) {
                code = "400";
                msg = "Business User not logged in";
            } else {
                if(!dispensaryPickUpOrderDao.updateTimeSlot(orderId, timeSlot)){
                    code = "500";
                    msg = "FAILED";
                }
            }
        } catch (Exception e) {
            logger.error("Exception Occurred while updating order time slot for order id : " + orderId, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }
}
