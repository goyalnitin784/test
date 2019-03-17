package com.phantom.model.dao.impl;

import com.phantom.model.dao.AskCommunityAnswerDao;
import com.phantom.model.entity.AskCommunityAnswer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AskCommunityAnswerDaoImpl  extends GenericHibernateDAO<AskCommunityAnswer, Long> implements AskCommunityAnswerDao {
}
