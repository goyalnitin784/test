package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryPickUpOrder;

import java.util.Date;
import java.util.List;

public interface DispensaryPickUpOrderDao extends GenericDAO<DispensaryPickUpOrder, Long> {
    void savePickUpOrder(DispensaryPickUpOrder dispensaryPickUpOrder);

    String getStatus(String orderId);

    boolean updateStatus(String orderId, String pickUpOrderStatus);

    List<DispensaryPickUpOrder> getOrdersByDispId(int dispId);

    List<DispensaryPickUpOrder> getOrdersByUserId(int userId);

    List<DispensaryPickUpOrder> getOrdersByOrderId(String orderId);

    boolean updatePickUpDate(String orderId, Date pickUpDate);
    boolean updateTimeSlot(String orderId, String timeSlot);
}
