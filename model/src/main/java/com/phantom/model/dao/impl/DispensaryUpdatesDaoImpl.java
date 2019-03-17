package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryUpdatesDao;
import com.phantom.model.entity.DispensaryUpdates;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryUpdatesDaoImpl  extends GenericHibernateDAO<DispensaryUpdates, Long> implements DispensaryUpdatesDao {
}
