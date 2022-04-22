package com.maplus.maplus.model;

import javax.persistence.*;

@Entity
public class UserRegister {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userRegisterId;
    @Column(nullable=false)
    public String userName;
    @Column(nullable=false)
    public int activityId ;

    public UserRegister(String userName,int activityId) {
        this.activityId = activityId;
        this.userName = userName;
    }

    public UserRegister() {
    }

    public int getUserRegisterId() {
        return userRegisterId;
    }

    public void setUserRegisterId(int userRegisterId) {
        this.userRegisterId = userRegisterId;
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
