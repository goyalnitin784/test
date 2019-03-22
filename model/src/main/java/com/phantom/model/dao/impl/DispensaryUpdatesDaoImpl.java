package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryUpdatesDao;
import com.phantom.model.entity.DispensaryUpdates;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryUpdatesDaoImpl  extends GenericHibernateDAO<DispensaryUpdates, Long> implements DispensaryUpdatesDao {
    @Override
    public void saveUpdates(DispensaryUpdates dispensaryUpdates) {
        try {
            super.saveOrUpdate(dispensaryUpdates);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }
}
