package com.maplus.maplus.service;



import java.util.List;

public interface UserRegisterService {
    public boolean addRegister(String username,int activityid);
    public boolean deleteRegister(String username, int activityid);
    public boolean checkRegister(String username, int activityid);

    public List<Object> getregisterActivities(String userName);
}
