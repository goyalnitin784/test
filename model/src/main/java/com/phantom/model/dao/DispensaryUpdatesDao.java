package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryUpdates;

import java.util.List;

public interface DispensaryUpdatesDao extends GenericDAO<DispensaryUpdates, Long> {
    void saveUpdates(DispensaryUpdates dispensaryUpdates);

    List<DispensaryUpdates> getUpdatesByDispId(int dispId);

    List<DispensaryUpdates> getUpdatesByUpdateId(String uuid);

    boolean editDispUpdates(String uuid, String dispUpdates);
}
