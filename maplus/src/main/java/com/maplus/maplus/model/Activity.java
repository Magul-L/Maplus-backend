package com.maplus.maplus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int activityID;
    @Column(nullable = false)
    private String clubName;
    private String publisher;
    
    @Column(columnDefinition = "DATETIME",nullable = false)
    private String beginTime;
    @Column(columnDefinition = "DATETIME",nullable = false)
    private String endTime;
    @Column(nullable = false)
    private String activityTitle;
    @Column(columnDefinition="LONGTEXT",nullable = false)
    private String activityDesc;
    @Column(nullable = false)
    private String building;
    @Column(nullable = false)
    private String room;
    
    private int estimateNum;

    private String targetPeople;
    private int registryNum;
    private int hot;
    public int getActivityID() {
        return activityID;
    }
    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }
    public String getClubName() {
        return clubName;
    }
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getBeginTime() {
        return beginTime;
    }
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getActivityTitle() {
        return activityTitle;
    }
    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }
    public String getActivityDesc() {
        return activityDesc;
    }
    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }
    public String getBuilding() {
        return building;
    }
    public void setBuilding(String building) {
        this.building = building;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public int getEstimateNum() {
        return estimateNum;
    }
    public void setEstimateNum(int estimateNum) {
        this.estimateNum = estimateNum;
    }
    public String getTargetPeople() {
        return targetPeople;
    }
    public void setTargetPeople(String targetPeople) {
        this.targetPeople = targetPeople;
    }
    public int getRegistryNum() {
        return registryNum;
    }
    public void setRegistryNum(int registryNum) {
        this.registryNum = registryNum;
    }
    public int getHot() {
        return hot;
    }
    public void setHot(int hot) {
        this.hot = hot;
    }
    

    
}
