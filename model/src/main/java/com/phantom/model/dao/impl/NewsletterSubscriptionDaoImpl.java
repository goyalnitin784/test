package com.phantom.model.dao.impl;

import com.phantom.model.dao.NewsletterSubscriptionDao;
import com.phantom.model.entity.NewsletterSubscription;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class NewsletterSubscriptionDaoImpl  extends GenericHibernateDAO<NewsletterSubscription, Long> implements NewsletterSubscriptionDao {
}
