package com.maplus.maplus.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Activity{
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
    @Column(columnDefinition="LONGTEXT")
    private String activityDetail;
    @Column(nullable = false)
    private String building;
    @Column(nullable = false)
    private String room;
    
    private int estimateNum;

    private String targetPeople;
    private int registryNum;
    private int hot;
    @Column(columnDefinition="LONGBLOB")
    private String picture1;
    @Column(columnDefinition="LONGBLOB")
    private String picture2;
    @Column(columnDefinition="LONGBLOB")
    private String picture3;
    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
    }
    public String getPicture1() {
        return picture1;
    }
    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }
    public String getPicture2() {
        return picture2;
    }
    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }
    public String getPicture3() {
        return picture3;
    }
    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }
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
    public String getActivityDetail() {
        return activityDetail;
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
