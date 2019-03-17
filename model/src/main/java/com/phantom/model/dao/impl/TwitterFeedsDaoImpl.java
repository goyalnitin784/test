package com.phantom.model.dao.impl;

import com.phantom.model.dao.TwitterFeedsDao;
import com.phantom.model.entity.TwitterFeeds;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TwitterFeedsDaoImpl extends GenericHibernateDAO<TwitterFeeds, Long> implements TwitterFeedsDao {
}
