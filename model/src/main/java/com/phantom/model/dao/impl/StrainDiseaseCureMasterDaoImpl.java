package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainDiseaseCureMasterDao;
import com.phantom.model.entity.StrainDiseaseCureMaster;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainDiseaseCureMasterDaoImpl extends GenericHibernateDAO<StrainDiseaseCureMaster, Long> implements StrainDiseaseCureMasterDao {
}
