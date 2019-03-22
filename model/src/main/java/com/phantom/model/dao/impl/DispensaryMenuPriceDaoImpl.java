package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryMenuPriceDao;
import com.phantom.model.entity.DispensaryMenuPrice;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryMenuPriceDaoImpl extends GenericHibernateDAO<DispensaryMenuPrice, Long> implements DispensaryMenuPriceDao {

    @Override
    public void saveMenuPrice(DispensaryMenuPrice dispensaryMenuPrice) {
        try {
            super.saveOrUpdate(dispensaryMenuPrice);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }
}
