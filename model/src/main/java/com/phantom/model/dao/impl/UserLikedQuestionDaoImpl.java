package com.phantom.model.dao.impl;

import com.phantom.model.dao.UserLikedQuestionDao;
import com.phantom.model.entity.UserLikedQuestion;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserLikedQuestionDaoImpl extends GenericHibernateDAO<UserLikedQuestion, Long> implements UserLikedQuestionDao {
}
