package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryDao;
import com.phantom.model.entity.Dispensary;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryDaoImpl  extends GenericHibernateDAO<Dispensary, Long> implements DispensaryDao {
}
