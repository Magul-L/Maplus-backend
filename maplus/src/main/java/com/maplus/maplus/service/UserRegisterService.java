package com.maplus.maplus.service;

import com.maplus.maplus.model.UserRegister;

import java.util.List;

public interface UserRegisterService {
    public boolean addRegister(String username,int activityid);

    public List<Object> getregisterActivities(String userName);
}
