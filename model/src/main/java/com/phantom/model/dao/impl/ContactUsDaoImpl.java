package com.phantom.model.dao.impl;

import com.phantom.model.dao.ContactUsDao;
import com.phantom.model.entity.ContactUs;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ContactUsDaoImpl  extends GenericHibernateDAO<ContactUs, Long> implements ContactUsDao {
}
