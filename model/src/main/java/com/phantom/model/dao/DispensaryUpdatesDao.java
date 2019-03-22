package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryReview;
import com.phantom.model.entity.DispensaryUpdates;

public interface DispensaryUpdatesDao extends GenericDAO<DispensaryUpdates,Long>{
    void saveUpdates(DispensaryUpdates dispensaryUpdates);

}
