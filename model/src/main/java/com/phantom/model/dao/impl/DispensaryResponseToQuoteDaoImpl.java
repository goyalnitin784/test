package com.phantom.model.dao.impl;

import com.phantom.model.dao.AskCommunityAnswerDao;
import com.phantom.model.dao.DispensaryResponseToQuoteDao;
import com.phantom.model.entity.AskCommunityAnswer;
import com.phantom.model.entity.DispensaryResponseToQuote;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryResponseToQuoteDaoImpl  extends GenericHibernateDAO<DispensaryResponseToQuote, Long> implements DispensaryResponseToQuoteDao {
}
