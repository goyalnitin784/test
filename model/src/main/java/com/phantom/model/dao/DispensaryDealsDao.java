package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryDeals;

import java.util.List;

public interface DispensaryDealsDao extends GenericDAO<DispensaryDeals, Long> {

    void saveDeals(DispensaryDeals dispensaryDeals);
    int isTrendingDispDeal(String uuid);
    int isFeaturedDespDeal(String uuid);
    boolean updateFollowers(String uuid);
    List<DispensaryDeals> findDealsNearYou(String lat, String longitude, String distance, int maxCount,
                                           boolean isFeaturedDeal, List<String> dispId);
    List<DispensaryDeals> findDispDeals(int dispId);
    DispensaryDeals getDealsByDealId(String dealId);
    boolean updateTotalLikes(String uuid);
}
