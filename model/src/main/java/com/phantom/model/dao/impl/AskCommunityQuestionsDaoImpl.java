package com.phantom.model.dao.impl;

import com.phantom.model.dao.AskCommunityQuestionsDao;
import com.phantom.model.entity.AskCommunityQuestions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AskCommunityQuestionsDaoImpl  extends GenericHibernateDAO<AskCommunityQuestions, Long> implements AskCommunityQuestionsDao {
}
