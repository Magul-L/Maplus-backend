package com.maplus.maplus.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int comID;

    @Column(nullable = false)
    private int activityID;
    private String userName;
    private String comtext;

    public int getActivityID() {
        return activityID;
    }
    public void setActivityID(int id) {
        this.activityID = id;
    }
    public String getUserName() {
        return userName;

    }
    public String getComtext() {
        return comtext;
    }
    public void setComtext(String comtext) {
        this.comtext = comtext;
    }

    public int getComID(){return comID;}

}

