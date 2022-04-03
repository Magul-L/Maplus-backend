package com.maplus.maplus.service;

import com.maplus.maplus.model.Activity;



import java.util.List;

public interface ActivityService {
    public List<Object> getActivities();

    public Object getStar(int actid);

    public int saveActivity(Activity activity);

    public boolean deleteActvity(int id);

    public Activity getActivity(int id);

    public int modifyActivity(int oldId,Activity activity);

    public int Hot(int id);

}
