package com.phantom.dispensary.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.phantom.dispensary.request.DispDealsBean;
import com.phantom.dispensary.request.DispMenuBean;
import com.phantom.dispensary.request.DispReviewBean;
import com.phantom.dispensary.request.DispensaryBean;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.*;
import com.phantom.model.entity.*;
import com.phantom.util.PhantomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DispensaryService {

    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

    @Autowired
    ProductsCategoryTypeDao productsCategoryTypeDao;

    @Autowired
    private DispensaryDao dispensaryDao;
    @Autowired
    private DispensaryReviewDao dispensaryReviewDao;

    @Autowired
    QuoteRequestSentToDao quoteRequestSentToDao;

    @Autowired
    BusinessUserSSOTokenMappingDao businessUserSSOTokenMappingDao;

    @Autowired
    private DispensaryDealsDao dispensaryDealsDao;

    @Autowired
    private DispensaryFollowersDao dispensaryFollowersDao;

    @Autowired
    private DispensaryGalleryDao dispensaryGalleryDao;

    @Autowired private DispensaryMenuDao dispensaryMenuDao;

    @Autowired private DispensaryMenuPriceDao dispensaryMenuPriceDao;


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

    public boolean addDispensary(DispensaryBean dispensaryBean) {
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

        } catch (Exception e) {
            logger.error("Exception occurred while adding dispensary : " + dispensaryBean.getDispensaryName(), e);
            return Boolean.FALSE;
        }
    }

    public String find(String userLat, String userLong) {
        String distanceInMiles = "20";
        List<Dispensary> dispensaries = dispensaryDao.findDOnLatLong(userLat, userLong, distanceInMiles, 20);
        if (dispensaries != null) {
            return new Gson().toJson(dispensaries);
        }
        return "";
    }

    public boolean review(DispReviewBean dispReviewBean) {
        try {
            DispensaryReview dispensaryReview = new DispensaryReview();

            dispensaryReview.setDispensaryId(dispReviewBean.getDispensaryId());
            dispensaryReview.setReviewerUserId(dispReviewBean.getReviewerUserId());
            dispensaryReview.setQualityRating(dispReviewBean.getQualityRating());
            dispensaryReview.setOverAllQualityRating(dispReviewBean.getOverAllQualityRating());
            dispensaryReview.setServiceRating(dispReviewBean.getServiceRating());
            dispensaryReview.setAtmosphereRating(dispReviewBean.getAtmosphereRating());
            dispensaryReview.setRecommendationCount(dispReviewBean.getRecommendationCount());
            dispensaryReview.setIsReviewHelpfulCount(dispReviewBean.getIsReviewHelpfulCount());
            dispensaryReview.setSharesCount(dispReviewBean.getSharesCount());
            dispensaryReview.setMakeReviewPrivate(dispReviewBean.getMakeReviewPrivate());
            dispensaryReview.setIsActive(dispReviewBean.getIsActive());
            dispensaryReview.setReviewDesc(dispReviewBean.getReviewDesc());
            dispensaryReview.setFollowers(dispReviewBean.getFollowers());
            dispensaryReview.setUuid(dispReviewBean.getUuid());

            dispensaryReviewDao.saveReview(dispensaryReview);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("Exception occurred while reviewing dispensary for dispensary id : " + dispReviewBean.getDispensaryId(), e);
            return Boolean.FALSE;
        }
    }

    public String getDispensaryQuote(String token) {
        JsonObject jsonObject = new JsonObject();
        if (PhantomUtil.isNullOrEmpty(token)) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "Not a logged in dispensary");
            return jsonObject.toString();
        }
        BusinessUserSSOTokenMapping businessUserSSOTokenMapping = businessUserSSOTokenMappingDao.getBusinessUserDetailsBySSOToken(token);
        long dispenseryId = businessUserSSOTokenMapping.getUserId();
        List<QuoteRequestSentTo> quoteRequestSentTos = quoteRequestSentToDao.getDispensaryQuoteInLastThreeDays((int) dispenseryId);
        if (quoteRequestSentTos == null || quoteRequestSentTos.size() == 0) {
            jsonObject.addProperty("status", 200);
            jsonObject.addProperty("msg", "No Quote present in last three days");
            return jsonObject.toString();
        }
        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "");
        jsonObject.add("data", new Gson().toJsonTree(quoteRequestSentTos));
        return jsonObject.toString();
    }

    public boolean addDeals(DispDealsBean dispDealsBean) {
        try {
            DispensaryDeals dispensaryDeals = new DispensaryDeals();

            dispensaryDeals.setDispensaryId(dispDealsBean.getDispensaryId());
            dispensaryDeals.setDealName(dispDealsBean.getDealName());
            dispensaryDeals.setValidityBeginDate(dispDealsBean.getValidityBeginDate());
            dispensaryDeals.setValidEndDate(dispDealsBean.getValidEndDate());
            dispensaryDeals.setDealDesc(dispDealsBean.getDealDesc());
            dispensaryDeals.setVoucherCode(dispDealsBean.getVoucherCode());
            dispensaryDeals.setDealTagLine(dispDealsBean.getDealTagLine());
            dispensaryDeals.setDiscountPercentage(dispDealsBean.getDiscountPercentage());
            dispensaryDeals.setDealImage1(dispDealsBean.getDealImage1());
            dispensaryDeals.setDealImage2(dispDealsBean.getDealImage2());
            dispensaryDeals.setIsTrendingDeal(dispDealsBean.getIsTrendingDeal());
            dispensaryDeals.setIsFeaturedDeal(dispDealsBean.getIsFeaturedDeal());
            dispensaryDeals.setIsActive(dispDealsBean.getIsActive());
            dispensaryDeals.setPrice(dispDealsBean.getPrice());
            dispensaryDeals.setSpecialComments(dispDealsBean.getSpecialComments());
            dispensaryDeals.setUuid(dispDealsBean.getUuid());
            dispensaryDeals.setFollowers(dispDealsBean.getFollowers());

            dispensaryDealsDao.saveDeals(dispensaryDeals);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary deals for dispensary id : " + dispDealsBean.getDispensaryId(), e);
            return Boolean.FALSE;
        }
    }

    public boolean addDispFollowers(int dispensaryId, int userId) {
        DispensaryFollowers dispensaryFollowers = new DispensaryFollowers();
        try {
            dispensaryFollowers.setDispensaryId(dispensaryId);
            dispensaryFollowers.setUserId(userId);
            dispensaryFollowers.setUuid(UUID.randomUUID().toString());

            dispensaryFollowersDao.saveFollowers(dispensaryFollowers);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("Exception occurred while adding dispensary followers ");
            return Boolean.FALSE;
        }
    }

    public boolean addGallery(int dispensaryId, int isActive, String picPath){
        DispensaryGallery dispensaryGallery = new DispensaryGallery();
        try {
            dispensaryGallery.setDispensaryId(dispensaryId);
            dispensaryGallery.setIsActive(isActive);
            dispensaryGallery.setUuid(UUID.randomUUID().toString());
            dispensaryGallery.setPicturePath(picPath);

            dispensaryGalleryDao.saveGallery(dispensaryGallery);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("Exception occurred while adding dispensary followers ");
            return Boolean.FALSE;
        }
    }

    public boolean addMenu(DispMenuBean dispMenuBean){
        try {
            DispensaryMenu dispensaryMenu = new DispensaryMenu();

            dispensaryMenu.setDispensaryId(dispMenuBean.getDispensaryId());
            dispensaryMenu.setProductName(dispMenuBean.getProductName());
            dispensaryMenu.setProductCategoryTypeId(dispMenuBean.getProductCategoryTypeId());
            dispensaryMenu.setStrainCategoryTypeId(dispMenuBean.getStrainCategoryTypeId());
            dispensaryMenu.setStrainId(dispMenuBean.getStrainId());
            dispensaryMenu.setBreeder(dispMenuBean.getBreeder());
            dispensaryMenu.setDescription(dispMenuBean.getDescription());
            dispensaryMenu.setProfileImage1(dispMenuBean.getProfileImage1());
            dispensaryMenu.setProfileImage2(dispMenuBean.getProfileImage2());
            dispensaryMenu.setProfileImage3(dispMenuBean.getProfileImage3());
            dispensaryMenu.setOtherDetails(dispMenuBean.getOtherDetails());
            dispensaryMenu.setCbdLevel(dispMenuBean.getCbdLevel());
            dispensaryMenu.setThcLevel(dispMenuBean.getThcLevel());
            dispensaryMenu.setUuid(dispMenuBean.getUuid());

            dispensaryMenuDao.saveMenu(dispensaryMenu);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary menu for dispensary id : " + dispMenuBean.getDispensaryId(), e);
            return Boolean.FALSE;
        }
    }

    public boolean addMenuPrice(int dispMenuId, String productPrice, String quantity, String currency){
        try {
            DispensaryMenuPrice dispensaryMenuPrice = new DispensaryMenuPrice();

            dispensaryMenuPrice.setDispensaryMenuId(dispMenuId);
            dispensaryMenuPrice.setCurrency(currency);
            dispensaryMenuPrice.setQuantity(quantity);
            dispensaryMenuPrice.setProductPrice(productPrice);
            dispensaryMenuPrice.setUuid(UUID.randomUUID().toString());

            dispensaryMenuPriceDao.saveMenuPrice(dispensaryMenuPrice);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary menu price for dispensary price menu id : " + dispMenuId, e);
            return Boolean.FALSE;
        }
    }
}
