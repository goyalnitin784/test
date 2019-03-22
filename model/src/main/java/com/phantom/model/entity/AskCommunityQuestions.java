package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ask_community_questions")
public class AskCommunityQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long questionId;

    @Column(name = "dispensary_id")
    private String dispensaryId;

    @Column(name = "strain_id")
    private String strainId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "question")
    private String question;

    @Column(name = "total_number_of_likes")
    private int totalLikes;

    @Column(name = "total_number_followed")
    private int totalFollower;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "uuid")
    private String uuid;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getDispensaryId() {
        return dispensaryId;
    }

    public void setDispensaryId(String dispensaryId) {
        this.dispensaryId = dispensaryId;
    }

    public String getStrainId() {
        return strainId;
    }

    public void setStrainId(String strainId) {
        this.strainId = strainId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public int getTotalFollower() {
        return totalFollower;
    }

    public void setTotalFollower(int totalFollower) {
        this.totalFollower = totalFollower;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
