package com.maplus.maplus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int userName;
    @Column(nullable=false)
    private String userPassword;
    @Column(nullable=false,length = 20)
    private String userNickname;
    private int userGroup;
    public int getUserName() {
        return userName;
    }
    public void setUserName(int userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserNickname() {
        return userNickname;
    }
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    public int getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(int userGroup) {
        this.userGroup = userGroup;
    }
    
}
