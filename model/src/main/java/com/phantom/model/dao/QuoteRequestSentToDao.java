package com.phantom.model.dao;

import com.phantom.model.entity.QuoteRequestSentTo;

import java.util.List;

public interface QuoteRequestSentToDao extends GenericDAO<QuoteRequestSentTo,Long>{

    List<QuoteRequestSentTo> getDispensaryQuote(int dispensaryId);
}
