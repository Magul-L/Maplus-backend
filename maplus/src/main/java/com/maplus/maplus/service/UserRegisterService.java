package com.maplus.maplus.service;



import java.util.List;
import java.util.Map;

public interface UserRegisterService {
    public boolean addRegister(String username,int activityid);
    public boolean deleteRegister(String username, int activityid);
    public boolean checkRegister(String username, int activityid);

    public List<Map<String,Object>> getregisterActivities(String userName);
}
