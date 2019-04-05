package com.phantom.model.dao;

import com.phantom.model.entity.Dispensary;

import java.util.List;

public interface DispensaryDao extends GenericDAO<Dispensary, Long> {
    void saveDispensary(Dispensary dispensary);
    List<Dispensary> findDispOnLatLong(String lat, String longitude, String distance, int maxCount, boolean isFeaturedDispensary);
    List<String> findDispIDNearYou(String lat, String longitude, String distance);
    long getDispId(String uuid);
    Dispensary getDispensaryByDispUuid(String dispUUID);
}
