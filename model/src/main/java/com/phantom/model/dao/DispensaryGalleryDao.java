package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryGallery;

import java.util.List;

public interface DispensaryGalleryDao extends GenericDAO<DispensaryGallery, Long> {
    void saveGallery(DispensaryGallery dispensaryGallery);

    List<DispensaryGallery> getDispGalleryByDispId(int dispId);

    boolean deleteDispGallery(String uuid);
}
