package com.phantom.model.dao;

import com.phantom.model.entity.QuoteRequestEntity;

import java.util.List;

public interface QuoteRequestDao extends GenericDAO<QuoteRequestEntity,Long>{

    List<QuoteRequestEntity> getMyQuote(int userId);
}
