package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainEffectsMasterDao;
import com.phantom.model.entity.StrainEffectsMaster;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainEffectsMasterDaoImpl extends GenericHibernateDAO<StrainEffectsMaster, Long> implements StrainEffectsMasterDao {
}
