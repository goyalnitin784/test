package com.phantom.model.dao.impl;

import com.phantom.model.dao.QuoteRequestSentToDao;
import com.phantom.model.entity.QuoteRequestSentTo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class QuoteRequestSentToDaoImpl  extends GenericHibernateDAO<QuoteRequestSentTo, Long> implements QuoteRequestSentToDao {
}
