package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryMenuPrice;

public interface DispensaryMenuPriceDao extends GenericDAO<DispensaryMenuPrice, Long> {
    void saveMenuPrice(DispensaryMenuPrice dispensaryMenuPrice);
}
