package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainFlavoursDao;
import com.phantom.model.entity.StrainFlavours;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainFlavoursDaoImpl  extends GenericHibernateDAO<StrainFlavours, Long> implements StrainFlavoursDao {
}
