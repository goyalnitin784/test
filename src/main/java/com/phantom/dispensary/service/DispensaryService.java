package com.phantom.dispensary.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.phantom.dispensary.request.DispensaryBean;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DispensaryDao;
import com.phantom.model.dao.ProductsCategoryTypeDao;
import com.phantom.model.entity.Dispensary;
import com.phantom.model.entity.ProductsCategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispensaryService {

    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

    @Autowired
    ProductsCategoryTypeDao productsCategoryTypeDao;

    @Autowired
    DispensaryDao dispensaryDao;

    public String getProductList() {
        try {
            List<ProductsCategoryType> productsCategoryTypeList = productsCategoryTypeDao.findAll();
            if (productsCategoryTypeList == null || productsCategoryTypeList.size() == 0) {
                return "[]";
            }
            JsonArray jsonElements = new JsonArray();
            for (ProductsCategoryType productsCategoryType : productsCategoryTypeList) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("category", productsCategoryType.getProductCategory());
                jsonObject.addProperty("desc", productsCategoryType.getDescription());
                jsonElements.add(jsonObject);
            }

            return jsonElements.toString();
        } catch (Exception e) {
            logger.error("Exception came while fetching product", e);
            return "[]";
        }
    }

    public boolean addDispensary(DispensaryBean dispensaryBean){
        try {
            Dispensary dispensary = new Dispensary();

            dispensary.setDispensaryName(dispensaryBean.getDispensaryName());
            dispensary.setIsActive(dispensaryBean.getIsActive());
            dispensary.setDispensaryProfilePic(dispensaryBean.getDispensaryProfilePic());
            dispensary.setDispensaryDesc(dispensaryBean.getDispensaryDesc());
            dispensary.setPhoneNo(dispensaryBean.getPhoneNo());
            dispensary.setEmail(dispensaryBean.getEmail());
            dispensary.setWebsite(dispensaryBean.getWebsite());
            dispensary.setAddress(dispensaryBean.getAddress());
            dispensary.setLongitude(dispensaryBean.getLongitude());
            dispensary.setLatitude(dispensaryBean.getLatitude());
            dispensary.setCity(dispensaryBean.getCity());
            dispensary.setState(dispensaryBean.getState());
            dispensary.setCountry(dispensaryBean.getCountry());
            dispensary.setFacilities(dispensaryBean.getFacilities());
            dispensary.setTimeZone(dispensaryBean.getTimeZone());
            dispensary.setMondayOpenOn(dispensaryBean.getMondayOpenOn());
            dispensary.setMondayClosedOn(dispensaryBean.getMondayClosedOn());
            dispensary.setTuesdayOpenOn(dispensaryBean.getTuesdayOpenOn());
            dispensary.setTuesdayClosedOn(dispensaryBean.getTuesdayClosedOn());
            dispensary.setWednesdayOpenOn(dispensaryBean.getWednesdayOpenOn());
            dispensary.setWednesdayClosedOn(dispensaryBean.getWednesdayClosedOn());
            dispensary.setThursdayOpenOn(dispensaryBean.getThursdayOpenOn());
            dispensary.setThursdayClosedOn(dispensaryBean.getThursdayClosedOn());
            dispensary.setFridayOpenOn(dispensaryBean.getFridayOpenOn());
            dispensary.setFridayClosedOn(dispensaryBean.getFridayClosedOn());
            dispensary.setSaturdayOpenOn(dispensaryBean.getSaturdayOpenOn());
            dispensary.setSaturdayClosedOn(dispensaryBean.getSaturdayClosedOn());
            dispensary.setSundayOpenOn(dispensaryBean.getSundayOpenOn());
            dispensary.setSundayClosedOn(dispensaryBean.getSundayClosedOn());
            dispensary.setIsVerifiedListing(dispensaryBean.getIsVerifiedListing());
            dispensary.setIsTrendingDispensary(dispensaryBean.getIsTrendingDispensary());
            dispensary.setIsFeaturedDispensary(dispensaryBean.getIsFeaturedDispensary());
            dispensary.setDateOfJoining(dispensaryBean.getDateOfJoining());
            dispensary.setFollowersCount(dispensaryBean.getFollowersCount());
            dispensary.setUuid(dispensaryBean.getUuid());

            // persisting dispensary data
            dispensaryDao.saveDispensary(dispensary);
            return Boolean.TRUE;

        }catch (Exception e){
            logger.error("Exception occurred while adding dispensary : "+dispensaryBean.getDispensaryName(), e);
            return Boolean.FALSE;
        }
    }
    public String find(String userLat, String userLong) {
        String distanceInMiles = "20";
        List<Dispensary> dispensaries = dispensaryDao.findDOnLatLong(userLat,userLong,distanceInMiles,20);
        if(dispensaries!=null){
            return new Gson().toJson(dispensaries);
        }
        return "";
    }

}
