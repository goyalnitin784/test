package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainReviewDao;
import com.phantom.model.entity.StrainReview;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StrainReviewDaoImpl  extends GenericHibernateDAO<StrainReview, Long> implements StrainReviewDao {
}
