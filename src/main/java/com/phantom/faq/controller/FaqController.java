package com.phantom.faq.controller;

import com.google.gson.JsonObject;
import com.phantom.faq.service.FaqService;
import com.phantom.logging.PhantomLogger;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FaqController {

    @Autowired
    FaqService faqService;

    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

    @RequestMapping(value = "askQuestion", method = RequestMethod.POST)
    public @ResponseBody
    String askQuestion(HttpServletRequest request) {
        try {
            String disId = request.getParameter("disId");
            String strainId = request.getParameter("strainId");
            String question = request.getParameter("question");
            String ssoToken = RequestUtils.getCookie(request, "ssoToken");
            return faqService.askQuestion(disId, strainId, question, ssoToken);
        } catch (Exception e) {
            logger.error("Exception came while ask question request", e);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", 500);
            jsonObject.addProperty("msg", "Question could not be uploaded");
            return jsonObject.toString();
        }
    }

    @RequestMapping(value = "likeQuestion", method = RequestMethod.GET)
    public @ResponseBody
    String likeQuestion(HttpServletRequest request) {
        try {
            String questionId = request.getParameter("questionId");
            return faqService.likeQuestion(questionId, RequestUtils.getCookie(request, "ssoToken"));
        } catch (Exception e) {
            logger.error("Exception came while liking question", e);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", 500);
            jsonObject.addProperty("msg", "Question not liked");
            return jsonObject.toString();
        }

    }

    @RequestMapping(value = "followQuestion", method = RequestMethod.GET)
    public @ResponseBody
    String followQuestion(HttpServletRequest request) {
        try {
            return faqService.followQuestion(request.getParameter("questionId"), RequestUtils.getCookie(request, "ssoToken"));
        } catch (Exception e) {
            logger.error("Exception came while liking question", e);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", 500);
            jsonObject.addProperty("msg", "Question not followed");
            return jsonObject.toString();
        }
    }

    @RequestMapping(value = "getQuestion", method = RequestMethod.GET)
    public @ResponseBody
    String getQuestion(HttpServletRequest request) {
        String ssoToken = RequestUtils.getCookie(request, "ssoToken");
        String disId = request.getParameter("disId");
        String strainId = request.getParameter("strainId");
        return faqService.getTopQuestions(ssoToken, disId, strainId);
    }

    @RequestMapping(value = "answerQuestion", method = RequestMethod.POST)
    public @ResponseBody
    String answerQuestion(HttpServletRequest request) {
        String ssoToken = RequestUtils.getCookie(request, "ssoToken");
        String bssoToken = RequestUtils.getCookie(request, "bssoToken");
        String questionId = request.getParameter("questionId");
        String answer = request.getParameter("answer");
        return faqService.answerQuestion(ssoToken, bssoToken, questionId, answer);
    }

    @RequestMapping(value = "likeAnswer", method = RequestMethod.GET)
    public @ResponseBody
    String likeAnswer(HttpServletRequest request) {
        try {
            String questionId = request.getParameter("answerId");
            return faqService.likeAnswer(questionId, RequestUtils.getCookie(request, "ssoToken"));
        } catch (Exception e) {
            logger.error("Exception came while liking question", e);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", 500);
            jsonObject.addProperty("msg", "Question not liked");
            return jsonObject.toString();
        }

    }

    @RequestMapping(value = "followAnswer", method = RequestMethod.GET)
    public @ResponseBody
    String followAnswer(HttpServletRequest request) {
        try {
            String answerId = request.getParameter("answerId");
            return faqService.followAnswer(answerId, RequestUtils.getCookie(request, "ssoToken"));
        } catch (Exception e) {
            logger.error("Exception came while liking answer", e);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", 500);
            jsonObject.addProperty("msg", "Answer not followed");
            return jsonObject.toString();
        }
    }

    @RequestMapping(value = "getAnswer", method = RequestMethod.GET)
    public @ResponseBody
    String getAnswer(HttpServletRequest request) {
        String questionId = request.getParameter("questionId");
        return faqService.getAnswers(questionId);
    }
}
