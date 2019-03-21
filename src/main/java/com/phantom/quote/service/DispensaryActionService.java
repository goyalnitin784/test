package com.phantom.quote.service;

import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DispensaryDao;
import com.phantom.model.dao.QuoteRequestSentToDao;
import com.phantom.model.entity.Dispensary;
import com.phantom.model.entity.QuoteRequestEntity;
import com.phantom.model.entity.QuoteRequestSentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispensaryActionService {

    @Autowired
    DispensaryDao dispensaryDao;

    @Autowired
    QuoteRequestSentToDao quoteRequestSentToDao;

    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

    public void act(QuoteRequestEntity quoteRequestEntity) {
        String lat = quoteRequestEntity.getLocationLat();
        String longitude = quoteRequestEntity.getLocationLong();
        List<Dispensary> dispensaryList = dispensaryDao.findDOnLatLong(lat, longitude, "30", 10);
        if (dispensaryList != null && dispensaryList.size() > 0) {
            for (Dispensary dispensary : dispensaryList) {
                QuoteRequestSentTo quoteRequestSentTo = new QuoteRequestSentTo();
                quoteRequestSentTo.setDispensaryId((int) dispensary.getId());
                quoteRequestSentTo.setQuoteRequestId((int) quoteRequestEntity.getId());
                quoteRequestSentToDao.saveOrUpdate(quoteRequestSentTo);
            }
        } else {
            logger.error("No Nearby Dispensary found for quote id : "+quoteRequestEntity.getId());
        }
    }

}
