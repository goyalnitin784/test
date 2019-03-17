package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainDao;
import com.phantom.model.entity.Strain;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public class StrainDaoImpl  extends GenericHibernateDAO<Strain, Long> implements StrainDao {
}
