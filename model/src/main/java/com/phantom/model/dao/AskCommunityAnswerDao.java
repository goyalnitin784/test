package com.phantom.model.dao;

import com.phantom.model.entity.AskCommunityAnswer;

import java.util.List;

public interface AskCommunityAnswerDao extends GenericDAO<AskCommunityAnswer, Long> {

    boolean saveAnswer(AskCommunityAnswer askCommunityAnswer);

    List<AskCommunityAnswer> getAllAnswers(String questionId,int count);

    boolean updateAnswerLike(int userId, String answerId);

    boolean updateAnswerFollow(int userId, String answerId);

}
