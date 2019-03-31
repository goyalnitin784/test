package com.phantom.model.dao.impl;

import com.phantom.model.dao.QuoteRequestSentToDao;
import com.phantom.model.entity.QuoteRequestSentTo;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class QuoteRequestSentToDaoImpl extends GenericHibernateDAO<QuoteRequestSentTo, Long> implements QuoteRequestSentToDao {
    @Override
    public List<QuoteRequestSentTo> getDispensaryQuote(int dispensaryId) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(QuoteRequestSentTo.class);
            criteria.add(Restrictions.eq("dispensaryId", 1));
            criteria.addOrder(Order.desc("createdOn"));
            return findByCriteria(criteria);
        } catch (Exception e) {
            logger.error("Exception occurred while fetching quote for dispensary id " + dispensaryId, e);
            return null;
        }
    }

}
