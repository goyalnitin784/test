package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryDeals;

public interface DispensaryDealsDao extends GenericDAO<DispensaryDeals, Long> {

    void saveDeals(DispensaryDeals dispensaryDeals);
    int isTrendingDispDeal(String uuid);
    int isFeaturedDespDeal(String uuid);
    boolean updateFollowers(String uuid);
}
