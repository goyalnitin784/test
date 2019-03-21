package com.phantom.model.dao;

import com.phantom.model.entity.Dispensary;

import java.util.List;

public interface DispensaryDao extends GenericDAO<Dispensary, Long> {
    void saveDispensary(Dispensary dispensary);
    List<Dispensary> findDOnLatLong(String lat, String longitude, String distance, int maxCount);
}
