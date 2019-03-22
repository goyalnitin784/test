package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryMenuDao;
import com.phantom.model.entity.DispensaryMenu;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryMenuDaoImpl extends GenericHibernateDAO<DispensaryMenu, Long> implements DispensaryMenuDao {
    @Override
    public void saveMenu(DispensaryMenu dispensaryMenu) {
        try {
            super.saveOrUpdate(dispensaryMenu);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }
}
