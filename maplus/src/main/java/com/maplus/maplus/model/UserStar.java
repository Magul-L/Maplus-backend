package com.maplus.maplus.model;

import javax.persistence.*;

@Entity
public class UserStar {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int starId;

    @Column(nullable=false)
    public String userName;

    @Column(nullable=false)
    public int activityId ;

    public UserStar(String userName,int activityId) {
        this.activityId = activityId;
        this.userName = userName;
    }

    public UserStar() {

    }
    public int getId() {
        return starId;
    }
    public void setId(int id) {
        this.starId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}
