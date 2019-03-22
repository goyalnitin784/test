package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "user_liked_question")
public class UserLikedQuestion {

    @Column(name = "user_id")
    int userId;

    @Column(name = "question_id")
    String questionId;

    @Column(name = "like_flag")
    int likeFlag;

    @Column(name = "follow_flag")
    int followFlag;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long userQuestionId;

    @Column(name = "created_on")
    private Date createdOn;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public long getUserQuestionId() {
        return userQuestionId;
    }

    public void setUserQuestionId(long userQuestionId) {
        this.userQuestionId = userQuestionId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getLikeFlag() {
        return likeFlag;
    }

    public void setLikeFlag(int likeFlag) {
        this.likeFlag = likeFlag;
    }

    public int getFollowFlag() {
        return followFlag;
    }

    public void setFollowFlag(int followFlag) {
        this.followFlag = followFlag;
    }
}
