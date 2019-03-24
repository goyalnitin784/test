package com.phantom.user.request;

import com.phantom.dispensary.request.DispReviewBean;
import com.phantom.logging.PhantomLogger;
import com.phantom.request.MapBasedRequest;
import com.phantom.util.PhantomUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

public class DealReviewBean extends MapBasedRequest {
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(DispReviewBean.class);
    private static final long serialVersionUID = 2941389692170682413L;

    private int dealId;
    private int dispensaryId;
    private String reviewDesc;
    private int overAllRating;
    private int recommendationCount;
    private int isReviewHelpfulCount;
    private int sharesCount;
    private int valueForMoneyRating;
    private int makeReviewPrivate;
    private int isActive = 0;
    private int dealCorrectnessRating;
    private int recommendForFuture;
    private int followers = 0;
    private String uuid = UUID.randomUUID().toString();

    private boolean isValidReview = Boolean.TRUE;

    public DealReviewBean(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    public DealReviewBean(Map<String, String> requestMap) {
        requestParameters = requestMap;
        postConstruct();
    }

    private void postConstruct() {
        try {
            dealId = Integer.parseInt(requestParameters.get("dealId"));
            dispensaryId = Integer.parseInt(requestParameters.get("dispId"));
            overAllRating = Integer.parseInt(requestParameters.get("overAllRating"));
            valueForMoneyRating = Integer.parseInt(requestParameters.get("valueForMoneyRating"));
            dealCorrectnessRating = Integer.parseInt(requestParameters.get("dealCorrectnessRating"));
            isReviewHelpfulCount = Integer.parseInt(requestParameters.get("isReviewHelpfulCount"));
            sharesCount = Integer.parseInt(requestParameters.get("sharesCount"));

        } catch (Exception e) {
            logger.error("Exception occurred while reviewing dispensary ", e);
            isValidReview = Boolean.FALSE;
        }
        if (isValidReview) {
            reviewDesc = requestParameters.get("reviewDesc");
            if (PhantomUtil.isNullOrEmpty(reviewDesc)) {
                isValidReview = Boolean.FALSE;
                if (requestParameters.get("followers") != null) {
                    followers = Integer.parseInt(requestParameters.get("followers"));
                }
                if (requestParameters.get("isActive") != null) {
                    isActive = Integer.parseInt(requestParameters.get("isActive"));
                }
                if (requestParameters.get("makeReviewPrivate") != null) {
                    makeReviewPrivate = Integer.parseInt(requestParameters.get("makeReviewPrivate"));
                }
                if (requestParameters.get("recommendationCount") != null) {
                    recommendationCount = Integer.parseInt(requestParameters.get("recommendationCount"));
                }
                if (requestParameters.get("recommendForFuture") != null) {
                    recommendForFuture = Integer.parseInt(requestParameters.get("recommendForFuture"));
                }
            }

        }


    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public int getDispensaryId() {
        return dispensaryId;
    }

    public void setDispensaryId(int dispensaryId) {
        this.dispensaryId = dispensaryId;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public int getOverAllRating() {
        return overAllRating;
    }

    public void setOverAllRating(int overAllRating) {
        this.overAllRating = overAllRating;
    }

    public int getRecommendationCount() {
        return recommendationCount;
    }

    public void setRecommendationCount(int recommendationCount) {
        this.recommendationCount = recommendationCount;
    }

    public int getIsReviewHelpfulCount() {
        return isReviewHelpfulCount;
    }

    public void setIsReviewHelpfulCount(int isReviewHelpfulCount) {
        this.isReviewHelpfulCount = isReviewHelpfulCount;
    }

    public int getSharesCount() {
        return sharesCount;
    }

    public void setSharesCount(int sharesCount) {
        this.sharesCount = sharesCount;
    }

    public int getValueForMoneyRating() {
        return valueForMoneyRating;
    }

    public void setValueForMoneyRating(int valueForMoneyRating) {
        this.valueForMoneyRating = valueForMoneyRating;
    }

    public int getMakeReviewPrivate() {
        return makeReviewPrivate;
    }

    public void setMakeReviewPrivate(int makeReviewPrivate) {
        this.makeReviewPrivate = makeReviewPrivate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getDealCorrectnessRating() {
        return dealCorrectnessRating;
    }

    public void setDealCorrectnessRating(int dealCorrectnessRating) {
        this.dealCorrectnessRating = dealCorrectnessRating;
    }

    public int getRecommendForFuture() {
        return recommendForFuture;
    }

    public void setRecommendForFuture(int recommendForFuture) {
        this.recommendForFuture = recommendForFuture;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isValidReview() {
        return isValidReview;
    }

    public void setValidReview(boolean validReview) {
        isValidReview = validReview;
    }
}
