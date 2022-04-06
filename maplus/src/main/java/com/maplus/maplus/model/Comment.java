package com.maplus.maplus.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int comId;

    @Column(nullable = false)
    public int activityId;
    private int userID;
    public String comtext;


    public Comment(int userId, int activityId,String comtext) {
        this.activityId = activityId;
        this.userID = userId;
        this.comtext = comtext;
    }

    public Comment() {
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int id) {
        this.activityId = id;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int id) {
        this.userID = id;
    }
    public String getComtext() {
        return comtext;
    }
    public void setComtext(String comtext) {
        this.comtext = comtext;
    }



}
