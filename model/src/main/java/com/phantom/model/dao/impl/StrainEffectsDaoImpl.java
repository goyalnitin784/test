package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainEffectsDao;
import com.phantom.model.entity.StrainEffects;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainEffectsDaoImpl  extends GenericHibernateDAO<StrainEffects, Long> implements StrainEffectsDao {
}
