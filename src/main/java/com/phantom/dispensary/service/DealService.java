package com.phantom.dispensary.service;

import com.google.gson.Gson;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DispensaryDealsDao;
import com.phantom.util.PhantomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealService {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(DealService.class);
    private final static Gson gson = new Gson();
    @Autowired private DispensaryDealsDao dispensaryDealsDao;

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
}
