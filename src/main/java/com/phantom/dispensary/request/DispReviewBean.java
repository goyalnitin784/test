package com.phantom.dispensary.request;

import com.phantom.logging.PhantomLogger;
import com.phantom.request.MapBasedRequest;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

public class DispReviewBean extends MapBasedRequest {
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(DispReviewBean.class);
    private static final long serialVersionUID = -1284382837820797675L;

    private int dispensaryId;
    private int reviewerUserId;
    private String reviewDesc;
    private int serviceRating;
    private int atmosphereRating;
    private int recommendationCount = 0;
    private int isReviewHelpfulCount = 0;
    private int sharesCount = 0;
    private int qualityRating;
    private int makeReviewPrivate = 0;
    private int isActive = 0;
    private int overAllQualityRating;
    private int followers = 0;
    private String uuid = UUID.randomUUID().toString();

    private boolean isValidReview = Boolean.TRUE;

    public DispReviewBean(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    public DispReviewBean(Map<String, String> requestMap) {
        requestParameters = requestMap;
        postConstruct();
    }

    private void postConstruct() {
        try {
            dispensaryId = Integer.parseInt(requestParameters.get("dispId"));
            serviceRating = Integer.parseInt(requestParameters.get("serviceRating"));
            atmosphereRating = Integer.parseInt(requestParameters.get("atmosphereRating"));
            qualityRating = Integer.parseInt(requestParameters.get("qualityRating"));

        } catch (Exception e) {
            logger.error("Exception occurred while reviewing dispensary ", e);
            isValidReview = Boolean.FALSE;
        }
        if (isValidReview) {
            reviewDesc = requestParameters.get("reviewDesc");
            if (requestParameters.get("makeReviewPrivate") != null) {
                makeReviewPrivate = Integer.parseInt(requestParameters.get("makeReviewPrivate"));
            }
            if (requestParameters.get("overAllQualityRating") != null) {
                overAllQualityRating = Integer.parseInt(requestParameters.get("overAllQualityRating"));
            }
        }

    }

    public int getDispensaryId() {
        return dispensaryId;
    }

    public void setDispensaryId(int dispensaryId) {
        this.dispensaryId = dispensaryId;
    }

    public int getReviewerUserId() {
        return reviewerUserId;
    }

    public void setReviewerUserId(int reviewerUserId) {
        this.reviewerUserId = reviewerUserId;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public int getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(int serviceRating) {
        this.serviceRating = serviceRating;
    }

    public int getAtmosphereRating() {
        return atmosphereRating;
    }

    public void setAtmosphereRating(int atmosphereRating) {
        this.atmosphereRating = atmosphereRating;
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

    public int getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(int qualityRating) {
        this.qualityRating = qualityRating;
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

    public int getOverAllQualityRating() {
        return overAllQualityRating;
    }

    public void setOverAllQualityRating(int overAllQualityRating) {
        this.overAllQualityRating = overAllQualityRating;
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
