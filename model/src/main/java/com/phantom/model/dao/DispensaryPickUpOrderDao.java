package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryPickUpOrder;

import java.util.List;

public interface DispensaryPickUpOrderDao extends GenericDAO<DispensaryPickUpOrder,Long>{
    public void savePickUpOrder (DispensaryPickUpOrder dispensaryPickUpOrder);
    public String getStatus (Long id);
    public List<DispensaryPickUpOrder> getOrdersByDispId(int dispId);
    public List<DispensaryPickUpOrder> getOrdersByUserId(int userId);
}
