package com.phantom.faq.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.phantom.business.user.service.BusinessUserService;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.AskCommunityAnswerDao;
import com.phantom.model.dao.AskCommunityQuestionsDao;
import com.phantom.model.dao.UserLikedQuestionDao;
import com.phantom.model.entity.*;
import com.phantom.user.service.UserService;
import com.phantom.util.PhantomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FaqService {

    @Autowired
    AskCommunityQuestionsDao askCommunityQuestionsDao;

    @Autowired
    AskCommunityAnswerDao askCommunityAnswerDao;

    @Autowired
    UserLikedQuestionDao userLikedQuestionDao;

    @Autowired
    UserService userService;

    @Autowired
    BusinessUserService businessUserService;

    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

    public String askQuestion(int disId, int strainId, String question, String ssoToken) {

        JsonObject jsonObject = new JsonObject();
        if (PhantomUtil.isNullOrEmpty(ssoToken)) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        User user = userService.getUserDetails(ssoToken);
        if (user == null) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        AskCommunityQuestions askCommunityQuestions = new AskCommunityQuestions();
        askCommunityQuestions.setCreatedOn(new Date());
        askCommunityQuestions.setDispensaryId(disId);
        askCommunityQuestions.setStrainId(strainId);
        askCommunityQuestions.setQuestion(question);
        askCommunityQuestions.setUserId((int) user.getUserId());
        askCommunityQuestions.setUuid(UUID.randomUUID().toString());
        try {
            askCommunityQuestionsDao.saveOrUpdate(askCommunityQuestions);
            jsonObject.addProperty("status", 200);
            jsonObject.addProperty("msg", "Question uploaded successfully");
            return jsonObject.toString();
        } catch (Exception e) {
            jsonObject.addProperty("status", 500);
            jsonObject.addProperty("msg", "Question could not be uploaded");
            return jsonObject.toString();
        }

    }

    public String likeQuestion(String questionId, String ssoToken) {
        JsonObject jsonObject = new JsonObject();
        if (PhantomUtil.isNullOrEmpty(ssoToken)) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        User user = userService.getUserDetails(ssoToken);
        if (user == null) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        askCommunityQuestionsDao.updateQuestionLike((int) user.getUserId(), questionId);

        try {
            UserLikedQuestion userLikedQuestion = new UserLikedQuestion();
            userLikedQuestion.setQuestionId(questionId);
            userLikedQuestion.setCreatedOn(new Date());
            userLikedQuestion.setUserId((int) user.getUserId());
            userLikedQuestion.setLikeFlag(1);
            userLikedQuestionDao.saveOrUpdate(userLikedQuestion);
        } catch (Exception e) {
            logger.error("Exception while saving user liked question for question id : " + questionId, e);
        }

        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "Question liked successfully");
        return jsonObject.toString();

    }

    public String followQuestion(String questionId, String ssoToken) {
        JsonObject jsonObject = new JsonObject();
        if (PhantomUtil.isNullOrEmpty(ssoToken)) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        User user = userService.getUserDetails(ssoToken);
        if (user == null) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        askCommunityQuestionsDao.updateQuestionFollow((int) user.getUserId(), questionId);
        try {
            UserLikedQuestion userLikedQuestion = new UserLikedQuestion();
            userLikedQuestion.setQuestionId(questionId);
            userLikedQuestion.setCreatedOn(new Date());
            userLikedQuestion.setUserId((int) user.getUserId());
            userLikedQuestion.setFollowFlag(1);
            userLikedQuestionDao.saveOrUpdate(userLikedQuestion);
        } catch (Exception e) {
            logger.error("Exception while saving user liked question for question id : " + questionId, e);
        }
        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "Question liked successfully");
        return jsonObject.toString();

    }

    public String getTopQuestions(String ssoToken, String dispId, String strainId) {

        JsonObject jsonObject = new JsonObject();


        int userId = 0;
        if (!PhantomUtil.isNullOrEmpty(ssoToken)) {
            User user = userService.getUserDetails(ssoToken);
            if (user != null) {
                userId = (int) user.getUserId();
            }
        }
        int count = 10;
        List<AskCommunityQuestions> askCommunityQuestionsList = askCommunityQuestionsDao.getTopQuestions(userId, dispId,strainId, count);
        jsonObject.addProperty("status", 200);
        jsonObject.add("data", new Gson().toJsonTree(askCommunityQuestionsList));
        return jsonObject.toString();
    }

    public String answerQuestion(String ssoToken, String bssoToken, String questionId, String answer) {

        JsonObject jsonObject = new JsonObject();
        if (PhantomUtil.isNullOrEmpty(ssoToken) || PhantomUtil.isNullOrEmpty(bssoToken)) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }
        int userId = 0;
        if (!PhantomUtil.isNullOrEmpty(ssoToken)) {
            User user = userService.getUserDetails(ssoToken);
            if (user == null) {
                jsonObject.addProperty("status", 400);
                jsonObject.addProperty("msg", "User not logged in");
                return jsonObject.toString();
            }
            userId = (int) user.getUserId();
        } else {
            BusinessUser user = businessUserService.getBusinessUserDetails(bssoToken);
            if (user == null) {
                jsonObject.addProperty("status", 400);
                jsonObject.addProperty("msg", "User not logged in");
                return jsonObject.toString();
            }
            userId = (int) user.getBusinessUserId();
        }
        AskCommunityAnswer askCommunityAnswer = new AskCommunityAnswer();
        askCommunityAnswer.setCreatedOn(new Date());
        askCommunityAnswer.setAnswer(answer);
        askCommunityAnswer.setQuestionId(Integer.parseInt(questionId));
        askCommunityAnswer.setUserId(userId);
        askCommunityAnswer.setUuid(UUID.randomUUID().toString());
        try {
            AskCommunityQuestions askCommunityQuestions = askCommunityQuestionsDao.getQuestion(questionId);
            askCommunityAnswer.setDispensaryId(askCommunityQuestions.getDispensaryId());
            askCommunityAnswer.setStrainId(askCommunityAnswer.getStrainId());
        } catch (Exception e) {
            logger.error("Exception came while fetching community question for question id : " + questionId, e);
        }
        try {
            askCommunityAnswerDao.saveOrUpdate(askCommunityAnswer);
            jsonObject.addProperty("status", 200);
            jsonObject.addProperty("msg", "Answer submitted properly");
            return jsonObject.toString();
        } catch (Exception e) {
            logger.error("Exception came while saving answer to question id : " + questionId, e);
        }
        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "Answer Could not be submitted properly");
        return jsonObject.toString();
    }

    public String likeAnswer(int answerId, String ssoToken) {
        JsonObject jsonObject = new JsonObject();
        if (PhantomUtil.isNullOrEmpty(ssoToken)) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        User user = userService.getUserDetails(ssoToken);
        if (user == null) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        askCommunityAnswerDao.updateAnswerLike((int) user.getUserId(), answerId);

        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "Answer liked successfully");
        return jsonObject.toString();

    }

    public String followAnswer(int answerId, String ssoToken) {
        JsonObject jsonObject = new JsonObject();
        if (PhantomUtil.isNullOrEmpty(ssoToken)) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        User user = userService.getUserDetails(ssoToken);
        if (user == null) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "User not logged in");
            return jsonObject.toString();
        }

        askCommunityAnswerDao.updateAnswerFollow((int) user.getUserId(), answerId);
        jsonObject.addProperty("status", 200);
        jsonObject.addProperty("msg", "Answer liked successfully");
        return jsonObject.toString();

    }

    public String getAnswers(String questionId) {

        JsonObject jsonObject = new JsonObject();


        int userId = 0;
        if (PhantomUtil.isNullOrEmpty(questionId)) {
            jsonObject.addProperty("status", 400);
            jsonObject.addProperty("msg", "Question Id can not be blank");
            return jsonObject.toString();
        }
        int count = 10;
        List<AskCommunityAnswer> askCommunityQuestionsList = askCommunityAnswerDao.getAllAnswers(Integer.parseInt(questionId), count);
        jsonObject.addProperty("status", 200);
        jsonObject.add("data", new Gson().toJsonTree(askCommunityQuestionsList));
        return jsonObject.toString();
    }
}
