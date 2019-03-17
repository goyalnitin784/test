package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryDealsDao;
import com.phantom.model.entity.DispensaryDeals;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryDealsDaoImpl  extends GenericHibernateDAO<DispensaryDeals, Long> implements DispensaryDealsDao {
}
