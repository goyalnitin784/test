package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainSpecMiscDetailsDao;
import com.phantom.model.entity.StrainSpecMiscDetails;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainSpecMiscDetailsDaoImpl  extends GenericHibernateDAO<StrainSpecMiscDetails, Long> implements StrainSpecMiscDetailsDao {
}
