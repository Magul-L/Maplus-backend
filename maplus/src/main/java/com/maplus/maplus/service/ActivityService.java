package com.maplus.maplus.service;

import com.maplus.maplus.model.Activity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ActivityService {
    public List<Activity> getActivities();

    public int saveActivity(Activity activity);

    public boolean deleteActvity(int id);

    public Activity getActivity(int id);

    public int modifyActivity(int oldId,Activity activity);
}
