package com.phantom.model.dao.impl;

import com.phantom.model.dao.QuoteRequestDao;
import com.phantom.model.entity.QuoteRequestEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class QuoteRequestDaoImpl  extends GenericHibernateDAO<QuoteRequestEntity, Long> implements QuoteRequestDao {
    @Override
    public List<QuoteRequestEntity> getMyQuote(int userId) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(QuoteRequestEntity.class);
            criteria.add(Restrictions.eq("userId", userId));
            criteria.addOrder(Order.desc("createdOn"));
            return findByCriteria(criteria);
        } catch (Exception e) {
            logger.error("Exception occurred while fetching User Quotes for user id :  "+userId, e);
            return null;
        }
    }
}
