package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryFollowers;

public interface DispensaryFollowersDao extends GenericDAO<DispensaryFollowers,Long>{

    public void saveFollowers(DispensaryFollowers dispensaryFollowers);
}
