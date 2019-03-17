package com.phantom.model.dao.impl;

import com.phantom.model.dao.ProductsCategoryTypeDao;
import com.phantom.model.entity.ProductsCategoryType;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ProductsCategoryTypeDaoImpl  extends GenericHibernateDAO<ProductsCategoryType, Long> implements ProductsCategoryTypeDao {
}
