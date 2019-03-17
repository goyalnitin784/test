package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainGalleryDao;
import com.phantom.model.entity.StrainGallery;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainGalleryDaoImpl  extends GenericHibernateDAO<StrainGallery, Long> implements StrainGalleryDao {
}
