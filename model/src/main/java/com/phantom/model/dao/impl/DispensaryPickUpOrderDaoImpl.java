package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryPickUpOrderDao;
import com.phantom.model.entity.DispensaryPickUpOrder;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryPickUpOrderDaoImpl  extends GenericHibernateDAO<DispensaryPickUpOrder, Long> implements DispensaryPickUpOrderDao {
}
