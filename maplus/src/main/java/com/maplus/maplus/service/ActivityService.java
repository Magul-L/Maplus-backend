package com.maplus.maplus.service;

import com.maplus.maplus.model.Activity;



import java.util.List;
import java.util.Map;

public interface ActivityService {
    public List<Map<String,Object>> getActivities();


    public int saveActivity(Activity activity);

    public boolean deleteActvity(int id);

    public Activity getActivity(int id);

    public int modifyActivity(int oldId,Activity activity);

    List<Activity> getsortActivity();

    public int Hot(int id);
    
    public  List<Map<String,Object>> searchActivity(String content);

    public  List<Activity> pageableActivity(int startpage,int endpage);

}
