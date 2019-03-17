package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainCategoryTypeDao;
import com.phantom.model.entity.StrainCategoryType;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainCategoryTypeDaoImpl  extends GenericHibernateDAO<StrainCategoryType, Long> implements StrainCategoryTypeDao {
}
