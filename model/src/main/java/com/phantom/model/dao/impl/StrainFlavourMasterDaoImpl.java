package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainFlavourMasterDao;
import com.phantom.model.entity.StrainFlavourMaster;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainFlavourMasterDaoImpl  extends GenericHibernateDAO<StrainFlavourMaster, Long> implements StrainFlavourMasterDao {
}
