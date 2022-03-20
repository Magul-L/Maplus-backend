package com.maplus.maplus.service;

import java.util.Optional;
import com.maplus.maplus.model.Activity;
import com.maplus.maplus.repo.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepo activityRepo;

    @Override
    public List<Activity> getActivities() {
        return activityRepo.findAll();
    }

    @Override
    public int saveActivity(Activity activity) {
        activityRepo.save(activity);
        return activityRepo.save(activity).getActivityID();
    }

    @Override
    public boolean deleteActvity(int id) {
            if(activityRepo.existsById(id)) {
                activityRepo.deleteById(id);
                return true;
            }
            else{
            return false;
        }

    }

    @Override
    public Activity getActivity(int id){
        Optional<Activity> acty= activityRepo.findById(id);
        return acty.isPresent()?acty.get():null;
    }

    @Override
    public int modifyActivity(int oldId,Activity act){
       if(activityRepo.existsById(oldId)) {
           activityRepo.deleteById(oldId);
           activityRepo.save(act);
           return activityRepo.save(act).getActivityID();
       }
       else
           return -1;
    }
}
