package com.phantom.dispensary.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.phantom.dispensary.request.DispMenuBean;
import com.phantom.dispensary.request.DispPickUpOrderBean;
import com.phantom.dispensary.request.DispReviewBean;
import com.phantom.dispensary.request.DispensaryBean;
import com.phantom.dto.BaseResponseDTO;
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
    private static final Gson gson = new Gson();

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

    @Autowired
    private DispensaryMenuDao dispensaryMenuDao;

    @Autowired
    private DispensaryMenuPriceDao dispensaryMenuPriceDao;

    @Autowired
    private DispensaryPickUpOrderDao dispensaryPickUpOrderDao;

    @Autowired
    private DispensaryPickUpOrderDetailsDao dispensaryPickUpOrderDetailsDao;

    @Autowired
    private DispensaryUpdatesDao dispensaryUpdatesDao;

    @Autowired
    private UserSSOTokenMappingDao userSSOTokenMappingDao;

    @Autowired
    private UserDao userDao;


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

    public boolean updateDispensaryDetails(DispensaryBean dispensaryBean) {

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

    public String findDispensary(String userLat, String userLong, String records, boolean isFeaturedDispensary) {
        String distanceInMiles = "20";
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            int maxCount = 500;
            if (!PhantomUtil.isNullOrEmpty(userLat) && !PhantomUtil.isNullOrEmpty(userLong)) {
                if (!PhantomUtil.isNullOrEmpty(records) || !records.equals("-1")) {
                    maxCount = Integer.parseInt(records);
                }
                List<Dispensary> dispensaries = dispensaryDao.findDispOnLatLong(userLat, userLong, distanceInMiles, maxCount, isFeaturedDispensary);
                if (dispensaries != null) {
                    response = new Gson().toJsonTree(dispensaries);
                }
            } else {
                msg = "BAD REQUEST";
                code = "400";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while finding featured dispensaries ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        baseResponseDTO.setResponse(response);
        return new Gson().toJson(baseResponseDTO);
    }

    public String addReviewForDispensary(DispReviewBean dispReviewBean) {
        String msg = "SUCCESS";
        String code = "200";
        int userId = dispReviewBean.getReviewerUserId();
        try {
            if (userId == -1) {
                code = "400";
                msg = "User Not Logged In";
            } else if (dispReviewBean.isValidReview()) {
                DispensaryReview dispensaryReview = new DispensaryReview();
                dispensaryReview.setDispensaryId(dispReviewBean.getDispensaryId());
                dispensaryReview.setReviewerUserId(userId);
                dispensaryReview.setQualityRating(dispReviewBean.getQualityRating());
                dispensaryReview.setOverAllQualityRating(dispReviewBean.getOverAllQualityRating());
                dispensaryReview.setServiceRating(dispReviewBean.getServiceRating());
                dispensaryReview.setAtmosphereRating(dispReviewBean.getAtmosphereRating());
                dispensaryReview.setReviewDesc(dispReviewBean.getReviewDesc());
                dispensaryReview.setUuid(dispReviewBean.getUuid());

                dispensaryReviewDao.saveReview(dispensaryReview);
            } else {
                msg = "BAD REQUEST";
                code = "400";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while reviewing dispensary for dispensary id : " + dispReviewBean.getDispensaryId(), e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
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
        List<QuoteRequestSentTo> quoteRequestSentTos = quoteRequestSentToDao.getDispensaryQuote((int) dispenseryId);
        if (quoteRequestSentTos == null || quoteRequestSentTos.size() == 0) {
            jsonObject.addProperty("status", 200);
            jsonObject.addProperty("msg", "No Quote present");
            return jsonObject.toString();
        }
        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "");
        jsonObject.add("data", new Gson().toJsonTree(quoteRequestSentTos));
        return jsonObject.toString();
    }

    public String followDispensary(String dispensaryId, int userId) {
        String code = "200";
        String msg = "SUCCESS";

        try {
            if (userId == -1) {
                code = "400";
                msg = "User Not Logged In";
            } else if (!PhantomUtil.isNullOrEmpty(dispensaryId)) {
                DispensaryFollowers dispensaryFollowers = new DispensaryFollowers();
                dispensaryFollowers.setDispensaryId(Integer.parseInt(dispensaryId));
                dispensaryFollowers.setUserId(userId);
                dispensaryFollowers.setUuid(UUID.randomUUID().toString());

                dispensaryFollowersDao.saveFollowers(dispensaryFollowers);
            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while adding dispensary followers ");
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String updateDispGallery(int dispensaryId, String picPath) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (dispensaryId == -1) {
                msg = "Business User Not Logged In";
                code = "400";
            } else if (!PhantomUtil.isNullOrEmpty(picPath)) {
                DispensaryGallery dispensaryGallery = new DispensaryGallery();
                dispensaryGallery.setDispensaryId(dispensaryId);
                dispensaryGallery.setIsActive(1);
                dispensaryGallery.setUuid(UUID.randomUUID().toString());
                dispensaryGallery.setPicturePath(picPath);
                dispensaryGalleryDao.saveGallery(dispensaryGallery);
                response = gson.toJsonTree(dispensaryGalleryDao.getDispGalleryByDispId(dispensaryId));
            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while adding dispensary followers ");
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String addMenu(DispMenuBean dispMenuBean) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (dispMenuBean.getDispensaryId() == -1) {
                msg = "Business User Not Logged In";
                code = "400";
            } else if (dispMenuBean.isValidMenu()) {
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
                response = gson.toJsonTree(dispensaryMenuDao.getMenuByDispId(dispMenuBean.getDispensaryId()));
            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary menu for dispensary id : " + dispMenuBean.getDispensaryId(), e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String editMenu(DispMenuBean dispMenuBean) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (dispMenuBean.getDispensaryId() == -1) {
                msg = "Business User Not Logged In";
                code = "400";
            } else if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getUuid())) {
                DispensaryMenu dispensaryMenu = dispensaryMenuDao.getMenuByMenuId(dispMenuBean.getUuid());

                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getProductName())) {
                    dispensaryMenu.setProductName(dispMenuBean.getProductName());
                }
                if (dispMenuBean.getProductCategoryTypeId() != -1) {
                    dispensaryMenu.setProductCategoryTypeId(dispMenuBean.getProductCategoryTypeId());
                }
                if (dispMenuBean.getStrainCategoryTypeId() != -1) {
                    dispensaryMenu.setStrainCategoryTypeId(dispMenuBean.getStrainCategoryTypeId());
                }
                if (dispMenuBean.getStrainId() != -1) {
                    dispensaryMenu.setStrainId(dispMenuBean.getStrainId());
                }
                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getBreeder())) {
                    dispensaryMenu.setBreeder(dispMenuBean.getBreeder());
                }
                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getDescription())) {
                    dispensaryMenu.setDescription(dispMenuBean.getDescription());
                }
                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getProfileImage1())) {
                    dispensaryMenu.setProfileImage1(dispMenuBean.getProfileImage1());
                }
                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getProfileImage2())) {
                    dispensaryMenu.setProfileImage2(dispMenuBean.getProfileImage2());
                }
                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getProfileImage3())) {
                    dispensaryMenu.setProfileImage3(dispMenuBean.getProfileImage3());
                }
                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getOtherDetails())) {
                    dispensaryMenu.setOtherDetails(dispMenuBean.getOtherDetails());
                }
                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getCbdLevel())) {
                    dispensaryMenu.setCbdLevel(dispMenuBean.getCbdLevel());
                }
                if (!PhantomUtil.isNullOrEmpty(dispMenuBean.getThcLevel())) {
                    dispensaryMenu.setThcLevel(dispMenuBean.getThcLevel());
                }

                dispensaryMenuDao.saveMenu(dispensaryMenu);
                response = gson.toJsonTree(dispensaryMenuDao.getMenuByDispId(dispMenuBean.getDispensaryId()));
            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating dispensary menu for dispensary id : " + dispMenuBean.getDispensaryId(), e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String updateDispensaryMenuPrice(String dispMenuId, String productPrice, String quantity, String currency) {
        String code = "200";
        String msg = "SUCCESS";
        try {
            if (PhantomUtil.isNullOrEmpty(dispMenuId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                DispensaryMenuPrice dispensaryMenuPrice = new DispensaryMenuPrice();

                dispensaryMenuPrice.setDispensaryMenuId(Integer.parseInt(dispMenuId));
                dispensaryMenuPrice.setCurrency(currency);
                dispensaryMenuPrice.setQuantity(quantity);
                dispensaryMenuPrice.setProductPrice(productPrice);
                dispensaryMenuPrice.setUuid(UUID.randomUUID().toString());

                dispensaryMenuPriceDao.saveMenuPrice(dispensaryMenuPrice);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary menu price for dispensary price menu id : " + dispMenuId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String placeOrder(DispPickUpOrderBean dispPickUpOrderBean) {
        String code = "200";
        String msg = "SUCCESS";
        try {
            if (dispPickUpOrderBean.getUserId() == -1) {
                msg = "User Not Logged In";
                code = "400";
            } else if (dispPickUpOrderBean.isValidPickUpOrder()) {
                DispensaryPickUpOrder dispensaryPickUpOrder = new DispensaryPickUpOrder();
                User user = userDao.findById(new Long(dispPickUpOrderBean.getUserId()));
                dispensaryPickUpOrder.setDispensaryId(dispPickUpOrderBean.getDispensaryId());
                dispensaryPickUpOrder.setDispensaryPickUpOrderCode(dispPickUpOrderBean.getDispensaryPickUpOrderCode());
                dispensaryPickUpOrder.setUserId(dispPickUpOrderBean.getUserId());
                dispensaryPickUpOrder.setPickUpDate(dispPickUpOrderBean.getPickUpDate());
                dispensaryPickUpOrder.setPickUpTimeSlot(dispPickUpOrderBean.getPickUpTimeSlot());
                dispensaryPickUpOrder.setSpecialComments(dispPickUpOrderBean.getSpecialComments());
                dispensaryPickUpOrder.setPickUpOrderStatus(dispPickUpOrderBean.getPickUpOrderStatus());
                dispensaryPickUpOrder.setPickUpRequestedOn(dispPickUpOrderBean.getPickUpRequestedOn());
                dispensaryPickUpOrder.setPickedUpBy(dispPickUpOrderBean.getPickedUpBy());
                dispensaryPickUpOrder.setTotalCost(dispPickUpOrderBean.getTotalCost());
                dispensaryPickUpOrder.setPickedUpBy(user.getUserName());
                dispensaryPickUpOrder.setUuid(dispPickUpOrderBean.getUuid());

                dispensaryPickUpOrderDao.savePickUpOrder(dispensaryPickUpOrder);
            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary pick up order for dispensary id : " + dispPickUpOrderBean.getDispensaryId(), e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String updateDispPickUpOrderDetails(String dispOrderId, String price, String quantity, String strainName) {
        String code = "200";
        String msg = "SUCCESS";
        try {
            if (PhantomUtil.isNullOrEmpty(dispOrderId) || PhantomUtil.isNullOrEmpty(price)
                    || PhantomUtil.isNullOrEmpty(quantity) || PhantomUtil.isNullOrEmpty(strainName)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                DispensaryPickUpOrderDetails dispensaryPickUpOrderDetails = new DispensaryPickUpOrderDetails();

                dispensaryPickUpOrderDetails.setDispensaryPickUpId(Integer.parseInt(dispOrderId));
                dispensaryPickUpOrderDetails.setPrice(Integer.parseInt(price));
                dispensaryPickUpOrderDetails.setQuantity(Integer.parseInt(quantity));
                dispensaryPickUpOrderDetails.setStrainName(strainName);
                dispensaryPickUpOrderDetails.setUuid(UUID.randomUUID().toString());

                dispensaryPickUpOrderDetailsDao.savePickUpPrderDetails(dispensaryPickUpOrderDetails);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary order details for dispensary pick up order id : " + dispOrderId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String updates(int dispId, String updateDetails) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (dispId == -1) {
                msg = "Business User Not Logged In";
                code = "400";
            } else if (!PhantomUtil.isNullOrEmpty(updateDetails)) {
                DispensaryUpdates dispensaryUpdates = new DispensaryUpdates();

                dispensaryUpdates.setDispensaryId(dispId);
                dispensaryUpdates.setUpdateDetails(updateDetails);
                dispensaryUpdates.setUuid(UUID.randomUUID().toString());

                dispensaryUpdatesDao.saveUpdates(dispensaryUpdates);
                response = gson.toJsonTree(dispensaryUpdatesDao.getUpdatesByDispId(dispId));

            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary updates for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String updateDispDesc(String description, int dispId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (dispId == -1 || PhantomUtil.isNullOrEmpty(description)) {
                msg = dispId == -1 ? "Business User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                Dispensary dispensary = dispensaryDao.findById((long) dispId);
                dispensary.setDispensaryDesc(description);
                dispensaryDao.saveDispensary(dispensary);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating dispensary description for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String updateDispAddress(String address, int dispId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (dispId == -1 || PhantomUtil.isNullOrEmpty(address)) {
                msg = dispId == -1 ? "Business User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                Dispensary dispensary = dispensaryDao.findById((long) dispId);
                dispensary.setAddress(address);
                dispensaryDao.saveDispensary(dispensary);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating dispensary address for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String addDispOperationHours(DispensaryBean dispensaryBean, int dispId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (dispId == -1 || dispensaryBean == null) {
                msg = dispId == -1 ? "Business User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                Dispensary dispensary = dispensaryDao.findById((long) dispId);

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

                dispensaryDao.saveDispensary(dispensary);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating dispensary address for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String updateDispLocation(String dispLat, String dispLong, int dispId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (dispId == -1 || PhantomUtil.isNullOrEmpty(dispLat) || PhantomUtil.isNullOrEmpty(dispLong)) {
                msg = dispId == -1 ? "Business User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                Dispensary dispensary = dispensaryDao.findById((long) dispId);
                dispensary.setLatitude(dispLat);
                dispensary.setLongitude(dispLong);
                dispensaryDao.saveDispensary(dispensary);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating dispensary location for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String addDispFacilities(String facilities, int dispId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (dispId == -1 || PhantomUtil.isNullOrEmpty(facilities)) {
                msg = dispId == -1 ? "Business User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                Dispensary dispensary = dispensaryDao.findById((long) dispId);
                dispensary.setFacilities(facilities);
                dispensaryDao.saveDispensary(dispensary);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while adding dispensary facilities for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String getDispensaryMenu(String dispUUID) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(dispUUID)) {
                msg = "BAD REQUEST";
                code = "400";
            } else {
                long dispId = dispensaryDao.getDispId(dispUUID);
                if(dispId != -1) {
                    response = gson.toJsonTree(dispensaryMenuDao.getMenuByDispId((int) dispId));
                }else {
                    msg = "Dispensary Id is Wrong";
                    code = "400";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while getting dispensary menu list for dispensary id : " + dispUUID, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }


    public String getDispUpdates(int dispId) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (dispId == -1) {
                msg = "Business User Not Logged In";
                code = "400";
            } else {
                response = gson.toJsonTree(dispensaryUpdatesDao.getUpdatesByDispId(dispId));
            }
        } catch (Exception e) {
            logger.error("Exception occurred while getting dispensary updates for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String editDispUpdates(int dispId, String updateId, String updateDetails) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (dispId == -1 || PhantomUtil.isNullOrEmpty(updateId) || PhantomUtil.isNullOrEmpty(updateDetails)) {
                msg = dispId == -1 ? "Business User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                if (dispensaryUpdatesDao.editDispUpdates(updateId, updateDetails)) {
                    response = gson.toJsonTree(dispensaryUpdatesDao.getUpdatesByDispId(dispId));
                } else {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary updates for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String getDispGallery(String dispensaryUUID) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(dispensaryUUID)) {
                msg = "BAD REQUEST";
                code = "400";
            } else {
                int dispId = (int) dispensaryDao.getDispId(dispensaryUUID);
                if(dispId!=-1) {
                    response = gson.toJsonTree(dispensaryGalleryDao.getDispGalleryByDispId(dispId));
                }else {
                    msg = "Dispensary Id is Wrong";
                    code = "400";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while getting dispensary gallery for dispensary id : " + dispensaryUUID, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String deleteDispGallery(int dispId, String dispGalleryUUID) {
        String code = "200";
        String msg = "SUCCESS";
        JsonElement response = null;
        try {
            if (dispId == -1 || PhantomUtil.isNullOrEmpty(dispGalleryUUID)) {
                msg = dispId == -1 ? "Business User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                if (dispensaryGalleryDao.deleteDispGallery(dispGalleryUUID)) {
                    response = gson.toJsonTree(dispensaryGalleryDao.getDispGalleryByDispId(dispId));
                } else {
                    code = "500";
                    msg = "FAILED";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while deleting dispensary gallery for dispensary id : " + dispId, e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

}
