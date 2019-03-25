package com.phantom.review.controller;

import com.phantom.review.service.ReviewService;
import com.phantom.user.service.UserService;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ReviewController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "recommendDispReview", method = RequestMethod.GET)
    public @ResponseBody
    String recommendDispReview(HttpServletRequest request, HttpServletResponse response) {
        String dispReviewId = request.getParameter("dispReviewId");
        return reviewService.recommendDispReview(dispReviewId);
    }

    @RequestMapping(value = "isDispReviewHelpful", method = RequestMethod.GET)
    public @ResponseBody
    String isDispReviewHelpful(HttpServletRequest request, HttpServletResponse response) {
        String dispReviewId = request.getParameter("dispReviewId");
        return reviewService.isDispReviewHelpful(dispReviewId);
    }

    @RequestMapping(value = "shareDispReview", method = RequestMethod.GET)
    public @ResponseBody
    String shareDispReview(HttpServletRequest request, HttpServletResponse response) {
        String dispReviewId = request.getParameter("dispReviewId");
        return reviewService.shareDispReview(dispReviewId);
    }

    @RequestMapping(value = "makeDispReviewPrivate", method = RequestMethod.GET)
    public @ResponseBody
    String makeDispReviewPrivate(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        String dispReviewId = request.getParameter("dispReviewId");
        return reviewService.makeDispReviewPrivate(userId, dispReviewId);
    }

    @RequestMapping(value = "makeDispReviewPublic", method = RequestMethod.GET)
    public @ResponseBody
    String makeDispReviewPublic(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        String dispReviewId = request.getParameter("dispReviewId");
        return reviewService.makeDispReviewPublic(userId, dispReviewId);
    }

    @RequestMapping(value = "followDispReview", method = RequestMethod.GET)
    public @ResponseBody
    String followDispReview(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        String dispReviewId = request.getParameter("dispReviewId");
        return reviewService.followDispReview(userId, dispReviewId);
    }

    @RequestMapping(value = "recommendDealReview", method = RequestMethod.GET)
    public @ResponseBody
    String recommendDealReview(HttpServletRequest request, HttpServletResponse response) {
        String dealReviewId = request.getParameter("dealReviewId");
        return reviewService.recommendDealReview(dealReviewId);
    }

    @RequestMapping(value = "isDealReviewHelpful", method = RequestMethod.GET)
    public @ResponseBody
    String isDealReviewHelpful(HttpServletRequest request, HttpServletResponse response) {
        String dealReviewId = request.getParameter("dealReviewId");
        return reviewService.isDealReviewHelpful(dealReviewId);
    }

    @RequestMapping(value = "shareDealReview", method = RequestMethod.GET)
    public @ResponseBody
    String shareDealReview(HttpServletRequest request, HttpServletResponse response) {
        String dealReviewId = request.getParameter("dealReviewId");
        return reviewService.shareDealReview(dealReviewId);
    }

    @RequestMapping(value = "makeDealReviewPrivate", method = RequestMethod.GET)
    public @ResponseBody
    String makeDealReviewPrivate(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        String dealReviewId = request.getParameter("dealReviewId");
        return reviewService.makeDealReviewPrivate(userId, dealReviewId);
    }

    @RequestMapping(value = "makeDealReviewPublic", method = RequestMethod.GET)
    public @ResponseBody
    String makeDealReviewPublic(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        String dealReviewId = request.getParameter("dealReviewId");
        return reviewService.makeDealReviewPublic(userId, dealReviewId);
    }

    @RequestMapping(value = "followDealReview", method = RequestMethod.GET)
    public @ResponseBody
    String followDealReview(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        String dealReviewId = request.getParameter("dealReviewId");
        return reviewService.followDealReview(userId, dealReviewId);
    }

    @RequestMapping(value = "recommendForFuture", method = RequestMethod.GET)
    public @ResponseBody
    String recommendForFuture(HttpServletRequest request, HttpServletResponse response) {
        int userId = userService.getUserId(RequestUtils.getCookie(request, "ssoToken"));
        String dealReviewId = request.getParameter("dealReviewId");
        return reviewService.recommendForFuture(userId, dealReviewId);
    }
}
