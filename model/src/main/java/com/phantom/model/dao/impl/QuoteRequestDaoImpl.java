package com.phantom.model.dao.impl;

import com.phantom.model.dao.QuoteRequestDao;
import com.phantom.model.entity.QuoteRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class QuoteRequestDaoImpl  extends GenericHibernateDAO<QuoteRequest, Long> implements QuoteRequestDao {
}
