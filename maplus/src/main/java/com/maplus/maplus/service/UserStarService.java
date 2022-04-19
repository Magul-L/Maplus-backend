package com.maplus.maplus.service;

import com.maplus.maplus.model.UserStar;

import java.util.List;
import java.util.Map;

public interface UserStarService {
    public boolean addStar(UserStar userstar);
    public boolean deleteStar(String username,int activityid);
    public boolean checkStar(String username,int activityid);
    public List<Map<String,Object>> getstarActivities(String userName);

}
