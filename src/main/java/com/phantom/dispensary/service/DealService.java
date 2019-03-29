package com.phantom.dispensary.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DispensaryDao;
import com.phantom.model.dao.DispensaryDealsDao;
import com.phantom.model.entity.Dispensary;
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
}
