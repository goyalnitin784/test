package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryGalleryDao;
import com.phantom.model.entity.DispensaryGallery;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryGalleryDaoImpl  extends GenericHibernateDAO<DispensaryGallery, Long> implements DispensaryGalleryDao {
}
