package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryMenuDao;
import com.phantom.model.entity.DispensaryMenu;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<DispensaryMenu> getMenuByDispId(int dispId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryMenu.class);
        criteria.add(Restrictions.eq("dispensaryId", dispId));
        criteria.addOrder(Order.desc("createdOn"));
        return findByCriteria(criteria);
    }

    @Override
    public DispensaryMenu getMenuByMenuId(String menuId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryMenu.class);
        criteria.add(Restrictions.eq("uuid", menuId));
        criteria.addOrder(Order.desc("createdOn"));
        return findByCriteria(criteria).get(0);
    }
}
