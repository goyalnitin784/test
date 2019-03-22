package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryPickUpOrder;

public interface DispensaryPickUpOrderDao extends GenericDAO<DispensaryPickUpOrder,Long>{
    public void savePickUpOrder (DispensaryPickUpOrder dispensaryPickUpOrder);
}
