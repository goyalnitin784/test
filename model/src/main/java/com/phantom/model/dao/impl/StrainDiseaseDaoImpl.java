package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainDiseaseDao;
import com.phantom.model.entity.StrainDisease;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainDiseaseDaoImpl  extends GenericHibernateDAO<StrainDisease, Long> implements StrainDiseaseDao {
}
