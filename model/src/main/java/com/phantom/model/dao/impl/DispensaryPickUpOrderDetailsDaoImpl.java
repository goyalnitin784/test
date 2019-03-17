package com.phantom.model.dao.impl;

import com.phantom.model.entity.DispensaryPickUpOrderDetails;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryPickUpOrderDetailsDaoImpl extends GenericHibernateDAO<DispensaryPickUpOrderDetails, Long> implements com.phantom.model.dao.DispensaryPickUpOrderDetailsDao {
}
