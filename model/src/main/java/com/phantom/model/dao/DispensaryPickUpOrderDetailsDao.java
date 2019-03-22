package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryPickUpOrderDetails;

public interface DispensaryPickUpOrderDetailsDao extends GenericDAO<DispensaryPickUpOrderDetails,Long>{
    public void savePickUpPrderDetails(DispensaryPickUpOrderDetails dispensaryPickUpOrderDetails);
}
