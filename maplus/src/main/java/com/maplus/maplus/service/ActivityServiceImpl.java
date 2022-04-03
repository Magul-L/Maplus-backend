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
    public List<Object> getActivities() {
        return activityRepo.findIntro();
    }
    @Override
    public Object getStar(int actid){
        return activityRepo.findStarIntro(actid);
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
    public int Hot(int id){
        activityRepo.addHot(id);
        Optional<Activity> isExist= activityRepo.findById(id);
        Activity activity = isExist.get();
        return activity.getHot();
    }

    @Override
    public int modifyActivity(int oldId,Activity act){
       if(activityRepo.existsById(oldId)) {
           activityRepo.updateActivity(act.getActivityDesc(),
                   act.getActivityTitle(),
                   act.getBeginTime(),
                   act.getBuilding(),
                   act.getClubName(),
                   act.getEndTime(),
                   act.getEstimateNum(),
                   act.getPublisher(),
                   act.getRoom(),
                   act.getTargetPeople(),
                   act.getActivityDetail(),
                   oldId);
           return oldId;
       }
       else
           return -1;
    }
    
    @Override
    public List<Object> searchActivity(String content){
        return activityRepo.searchActivity(content);
    }
}
