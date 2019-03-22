package com.phantom.model.dao.impl;

import com.phantom.model.entity.DispensaryPickUpOrderDetails;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryPickUpOrderDetailsDaoImpl extends GenericHibernateDAO<DispensaryPickUpOrderDetails, Long> implements com.phantom.model.dao.DispensaryPickUpOrderDetailsDao {
    @Override
    public void savePickUpPrderDetails(DispensaryPickUpOrderDetails dispensaryPickUpOrderDetails) {
        try {
            super.saveOrUpdate(dispensaryPickUpOrderDetails);
        }catch (Exception e){
            logger.error("Exception came while saving object", e);
        }
    }
}
