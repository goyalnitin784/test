package com.phantom.quote.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.QuoteRequestDao;
import com.phantom.model.entity.QuoteRequestEntity;
import com.phantom.model.entity.User;
import com.phantom.quote.request.QuoteRequest;
import com.phantom.user.service.UserService;
import com.phantom.util.PhantomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class QService {

    @Autowired
    UserService userService;

    @Autowired
    QuoteRequestDao quoteRequestDao;

    @Autowired
    DispensaryActionService dispensaryActionService;

    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

    public String getQuote(QuoteRequest quoteRequest) {

        JsonObject jsonObject = new JsonObject();
        if (PhantomUtil.isNullOrEmpty(quoteRequest.getSsoToken())) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        if (PhantomUtil.isNullOrEmpty(quoteRequest.getQuantity())) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "Product Quantity can not be blank");
            return jsonObject.toString();
        }
        if (PhantomUtil.isNullOrEmpty(quoteRequest.getProduct())) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "Strain Details can not be blank");
            return jsonObject.toString();
        }
        if (PhantomUtil.isNullOrEmpty(quoteRequest.getLocationLat())) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User Location can not be blank");
            return jsonObject.toString();
        }
        User user = userService.getUserDetails(quoteRequest.getSsoToken());
        if (user == null) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User Not Logged In");
            return jsonObject.toString();
        }

        try {
            QuoteRequestEntity quoteRequestEntity = new QuoteRequestEntity();
            quoteRequestEntity.setLocationLat(quoteRequest.getLocationLat());
            quoteRequestEntity.setLocationLong(quoteRequest.getLocationLong());
            quoteRequestEntity.setCreatedOn(new Date());
            quoteRequestEntity.setComments(quoteRequest.getComments());
            quoteRequestEntity.setStrainDetails(quoteRequest.getProduct());
            quoteRequestEntity.setUserId((int) user.getUserId());
            quoteRequestEntity.setUuid(UUID.randomUUID().toString());
            quoteRequestDao.saveOrUpdate(quoteRequestEntity);
            dispensaryActionService.act(quoteRequestEntity);
        } catch (Exception e) {
            logger.error("Exception came while saving quoue", e);
            jsonObject.addProperty("status", 500);
            jsonObject.addProperty("msg", "Request Could not be Submitted");
        }
        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "Request Submitted");
        return jsonObject.toString();
    }

    public String getUserQuote(String ssoToken) {
        User user = userService.getUserDetails(ssoToken);
        JsonObject jsonObject = new JsonObject();
        if (user == null) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }
        List<QuoteRequestEntity> quoteRequestEntityList = quoteRequestDao.getMyQuote((int) user.getUserId());
        if (quoteRequestEntityList == null || quoteRequestEntityList.size() == 0) {
            jsonObject.addProperty("status", 200);
            jsonObject.addProperty("msg", "No Quote Present");
            return jsonObject.toString();
        }
        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "");
        jsonObject.add("data", new Gson().toJsonTree(quoteRequestEntityList));
        return jsonObject.toString();
    }

}
