package com.phantom.model.dao.impl;

import com.phantom.model.dao.QuoteRequestSentToDao;
import com.phantom.model.entity.QuoteRequestSentTo;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Transactional
public class QuoteRequestSentToDaoImpl  extends GenericHibernateDAO<QuoteRequestSentTo, Long> implements QuoteRequestSentToDao {
    @Override
    public List<QuoteRequestSentTo> getDispensaryQuoteInLastThreeDays(int dispensaryId) {
        try {
            Date now = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR,-3);
            DetachedCriteria criteria = DetachedCriteria.forClass(QuoteRequestSentTo.class);
            criteria.add(Restrictions.eq("dispensaryId",1));
            criteria.add(Restrictions.gt("createdOn",calendar.getTime()));
            criteria.addOrder(Order.desc("createdOn"));
            return findByCriteria(criteria);
        } catch (Exception e) {
            logger.error("Exception occurred while fetching user details by sso token ", e);
            return null;
        }
    }


}
