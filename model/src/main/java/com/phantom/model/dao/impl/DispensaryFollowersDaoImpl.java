package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryFollowersDao;
import com.phantom.model.entity.DispensaryFollowers;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryFollowersDaoImpl extends GenericHibernateDAO<DispensaryFollowers, Long> implements DispensaryFollowersDao {
    @Override
    public void saveFollowers(DispensaryFollowers dispensaryFollowers) {
        try {
            super.saveOrUpdate(dispensaryFollowers);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }
}
