package com.phantom.model.dao.impl;

import com.phantom.model.dao.TestimonialsDao;
import com.phantom.model.entity.Testimonials;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TestimonialsDaoImpl  extends GenericHibernateDAO<Testimonials, Long> implements TestimonialsDao {
}
