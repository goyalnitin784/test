package com.phantom.model.dao;

import com.phantom.model.entity.AskCommunityQuestions;

import java.util.List;

public interface AskCommunityQuestionsDao extends GenericDAO<AskCommunityQuestions, Long> {

    AskCommunityQuestions getQuestion(String uuid);

    List<AskCommunityQuestions> getTopQuestions(int userId, String dispId, String strainId, int count);

    boolean updateQuestionLike(int userId, String questionId);

    boolean updateQuestionFollow(int userId, String questionId);


}
