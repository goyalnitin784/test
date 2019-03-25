package com.phantom.review.service;

import com.google.gson.Gson;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DealReviewDao;
import com.phantom.model.dao.DispensaryReviewDao;
import com.phantom.util.PhantomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(ReviewService.class);
    private static final Gson gson = new Gson();

    @Autowired
    private DispensaryReviewDao dispensaryReviewDao;
    @Autowired
    private DealReviewDao dealReviewDao;

    public String recommendDispReview(String dispReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dispReviewId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (!dispensaryReviewDao.updateRecommendCount(dispReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while recommending dispensary review ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String isDispReviewHelpful(String dispReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dispReviewId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (!dispensaryReviewDao.updateReviewHelpfulCount(dispReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while dispensary review helpful count", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String shareDispReview(String dispReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dispReviewId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (!dispensaryReviewDao.updateShareCount(dispReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while dispensary review helpful count", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String makeDispReviewPrivate(int userId, String dispReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (userId == -1 || PhantomUtil.isNullOrEmpty(dispReviewId)) {
                code = "400";
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
            } else {
                if (!dispensaryReviewDao.makeDispReviewPrivate(dispReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while making dispensary review private", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String makeDispReviewPublic(int userId, String dispReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (userId == -1 || PhantomUtil.isNullOrEmpty(dispReviewId)) {
                code = "400";
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
            } else {
                if (!dispensaryReviewDao.makeDispReviewPublic(dispReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while making dispensary review public", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String followDispReview(int userId, String dispReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (userId == -1 || PhantomUtil.isNullOrEmpty(dispReviewId)) {
                code = "400";
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
            } else {
                if (!dispensaryReviewDao.followDispReview(dispReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while dispensary review helpful count", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String recommendDealReview(String dealReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dealReviewId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (!dealReviewDao.updateRecommendCount(dealReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while recommending deal review ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String isDealReviewHelpful(String dealReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dealReviewId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (!dealReviewDao.updateReviewHelpfulCount(dealReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while deal review helpful count", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String shareDealReview(String dealReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(dealReviewId)) {
                code = "400";
                msg = "BAD REQUEST";
            } else {
                if (!dealReviewDao.updateShareCount(dealReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while deal review helpful count", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String makeDealReviewPrivate(int userId, String dealReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (userId == -1 || PhantomUtil.isNullOrEmpty(dealReviewId)) {
                code = "400";
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
            } else {
                if (!dealReviewDao.makeDealReviewPrivate(dealReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while making deal review private", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String makeDealReviewPublic(int userId, String dealReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (userId == -1 || PhantomUtil.isNullOrEmpty(dealReviewId)) {
                code = "400";
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
            } else {
                if (!dealReviewDao.makeDealReviewPublic(dealReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while making deal review private", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String followDealReview(int userId, String dealReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (userId == -1 || PhantomUtil.isNullOrEmpty(dealReviewId)) {
                code = "400";
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
            } else {
                if (!dealReviewDao.followDealReview(dealReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating deal review helpful count", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String recommendForFuture(int userId, String dealReviewId) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (userId == -1 || PhantomUtil.isNullOrEmpty(dealReviewId)) {
                code = "400";
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
            } else {
                if (!dealReviewDao.recommendForFuture(dealReviewId)) {
                    msg = "FAILED";
                    code = "500";
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while recommending deal review for future ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }
}
