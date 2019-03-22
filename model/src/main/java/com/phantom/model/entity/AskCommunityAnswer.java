package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ask_community_answers")
public class AskCommunityAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private String dispensaryId;

    @Column(name = "strain_id")
    private String strainId;

    @Column(name = "question_id")
    private String questionId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "answer")
    private String answer;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "total_number_of_likes")
    private int totalLikes;

    @Column(name = "total_number_followed")
    private int totalFollower;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
