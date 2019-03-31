package com.phantom.dispensary.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.phantom.dispensary.request.DispDealsBean;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DispensaryDao;
import com.phantom.model.dao.DispensaryDealsDao;
import com.phantom.model.entity.DispensaryDeals;
import com.phantom.util.PhantomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(DealService.class);
    private final static Gson gson = new Gson();
    @Autowired private DispensaryDealsDao dispensaryDealsDao;
    @Autowired private DispensaryDao dispensaryDao;

    public String addDeals(DispDealsBean dispDealsBean) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (dispDealsBean.getDispensaryId() == -1) {
                msg = "Business User Not Logged In";
                code = "400";
            } else if (dispDealsBean.isValidDeal()) {
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
                dispensaryDeals.setLikes(dispDealsBean.getLikes());

                dispensaryDealsDao.saveDeals(dispensaryDeals);
                response = gson.toJsonTree(dispensaryDealsDao.findDispDeals(dispDealsBean.getDispensaryId()));
            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary deals for dispensary id : " + dispDealsBean.getDispensaryId(), e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String editDeals(DispDealsBean dispDealsBean) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (dispDealsBean.getDispensaryId() == -1) {
                msg = "Business User Not Logged In";
                code = "400";
            } else if (!PhantomUtil.isNullOrEmpty(dispDealsBean.getUuid())) {
                DispensaryDeals dispensaryDeals = dispensaryDealsDao.getDealsByDealId(dispDealsBean.getUuid());

                if(!PhantomUtil.isNullOrEmpty(dispDealsBean.getDealName())) {
                    dispensaryDeals.setDealName(dispDealsBean.getDealName());
                }
                if(dispDealsBean.getValidityBeginDate()!=null) {
                    dispensaryDeals.setValidityBeginDate(dispDealsBean.getValidityBeginDate());
                }
                if(dispDealsBean.getValidEndDate()!=null) {
                    dispensaryDeals.setValidEndDate(dispDealsBean.getValidEndDate());
                }
                if(!PhantomUtil.isNullOrEmpty(dispDealsBean.getDealDesc())) {
                    dispensaryDeals.setDealDesc(dispDealsBean.getDealDesc());
                }
                if(!PhantomUtil.isNullOrEmpty(dispDealsBean.getVoucherCode())) {
                    dispensaryDeals.setVoucherCode(dispDealsBean.getVoucherCode());
                }
                if(!PhantomUtil.isNullOrEmpty(dispDealsBean.getDealTagLine())) {
                    dispensaryDeals.setDealTagLine(dispDealsBean.getDealTagLine());
                }
                if(!PhantomUtil.isNullOrEmpty(dispDealsBean.getDiscountPercentage())) {
                    dispensaryDeals.setDiscountPercentage(dispDealsBean.getDiscountPercentage());
                }
                if(!PhantomUtil.isNullOrEmpty(dispDealsBean.getDealImage1())) {
                    dispensaryDeals.setDealImage1(dispDealsBean.getDealImage1());
                }
                if(!PhantomUtil.isNullOrEmpty(dispDealsBean.getDealImage2())) {
                    dispensaryDeals.setDealImage2(dispDealsBean.getDealImage2());
                }
                if(dispDealsBean.getPrice() != -1) {
                    dispensaryDeals.setPrice(dispDealsBean.getPrice());
                }
                if(!PhantomUtil.isNullOrEmpty(dispDealsBean.getSpecialComments())) {
                    dispensaryDeals.setSpecialComments(dispDealsBean.getSpecialComments());
                }
                if(dispDealsBean.getFollowers()!=0 ) {
                    dispensaryDeals.setFollowers(dispDealsBean.getFollowers());
                }
                if(dispDealsBean.getIsFeaturedDeal() != 0){
                    dispensaryDeals.setIsFeaturedDeal(dispDealsBean.getIsFeaturedDeal());
                }
                if(dispDealsBean.getIsTrendingDeal() != 0){
                    dispensaryDeals.setIsFeaturedDeal(dispDealsBean.getIsTrendingDeal());
                }
                if(dispDealsBean.getLikes() != 0){
                    dispensaryDeals.setLikes(dispDealsBean.getLikes());
                }

                dispensaryDealsDao.saveDeals(dispensaryDeals);
                response = gson.toJsonTree(dispensaryDealsDao.findDispDeals(dispDealsBean.getDispensaryId()));
            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occurred while saving dispensary deals for dispensary id : " + dispDealsBean.getDispensaryId(), e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String isTrendingDispDeal(String dispDealId) {
        String msg = "TRUE";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dispDealId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (dispensaryDealsDao.isTrendingDispDeal(dispDealId) != 1) {
                    msg = "FALSE";
                    code = "200";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while checking dispensary is trending or not ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String isFeaturedDespDeal(String dispDealId) {
        String msg = "TRUE";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dispDealId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (dispensaryDealsDao.isFeaturedDespDeal(dispDealId) != 1) {
                    msg = "FALSE";
                    code = "200";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while checking dispensary is trending or not ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String followDispDeal(String dispDealId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dispDealId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (!dispensaryDealsDao.updateFollowers(dispDealId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while checking dispensary is trending or not ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String findDealsNearYou(String userLat, String userLong, String records, boolean isFeaturedDeal) {
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
                List<String> dispIdList = dispensaryDao.findDispIDNearYou(userLat,userLat,distanceInMiles);
                List<DispensaryDeals> deals = dispensaryDealsDao.findDealsNearYou(userLat, userLong, distanceInMiles, maxCount, isFeaturedDeal, dispIdList);
                if (deals != null) {
                    response = new Gson().toJsonTree(deals);
                }
            } else {
                msg = "BAD REQUEST";
                code = "400";
            }
        }catch (Exception e){
            logger.error("Exception occurred while finding dispensary deals ",e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        baseResponseDTO.setResponse(response);
        return new Gson().toJson(baseResponseDTO);
    }

    public String getDispDeals(int dispId) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (dispId != -1) {
                List<DispensaryDeals> deals = dispensaryDealsDao.findDispDeals(dispId);
                if (deals != null) {
                    response = new Gson().toJsonTree(deals);
                }
            } else {
                msg = "Business User Not Logged In";
                code = "400";
            }
        }catch (Exception e){
            logger.error("Exception occurred while finding dispensary deals ",e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        baseResponseDTO.setResponse(response);
        return new Gson().toJson(baseResponseDTO);
    }

    public String makeDealActiveOrInactive(int dispId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (dispId != -1) {
                List<DispensaryDeals> deals = dispensaryDealsDao.findDispDeals(dispId);
                if (deals != null) {
                    for(DispensaryDeals deal : deals){
                        int isActive = deal.getIsActive()== 0 ? 1 : 0;
                        deal.setIsActive(isActive);
                    }
                }
            } else {
                msg = "Business User Not Logged In";
                code = "400";
            }
        }catch (Exception e){
            logger.error("Exception occurred while finding dispensary deals ",e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        return new Gson().toJson(baseResponseDTO);
    }

    public String likeDispDeal(String dispDealId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dispDealId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (!dispensaryDealsDao.updateTotalLikes(dispDealId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while liking dispensary deal for deal id "+ dispDealId, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }
}
