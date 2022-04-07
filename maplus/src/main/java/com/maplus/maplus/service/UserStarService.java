package com.maplus.maplus.service;

import com.maplus.maplus.model.UserStar;

import java.util.List;

public interface UserStarService {
    public boolean addStar(UserStar userstar);
    public boolean deleteStar(String username,int activityid);
    public boolean checkStar(String username,int activityid);
    public List<Object> getstarActivities(String userName);

}
