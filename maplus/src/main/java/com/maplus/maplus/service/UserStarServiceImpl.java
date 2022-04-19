package com.maplus.maplus.service;


import com.maplus.maplus.model.UserStar;
import com.maplus.maplus.repo.ActivityRepo;
import com.maplus.maplus.repo.UserStarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserStarServiceImpl implements UserStarService{
    @Autowired
    private UserStarRepo userStarRepo;
    @Autowired
    private ActivityRepo activityRepo;
    @Override
    public boolean addStar(UserStar userstar){
       try{

           userStarRepo.save(userstar);
           return true;
       }
        catch (Exception e){
           return false;
        }

    }
    @Override
    public boolean deleteStar(String username,int activityid){
        int resultid=userStarRepo.deleteAllByUserNameAndActivityId(username,activityid);
        if(resultid!=-1)
            return true;
        else
            return false;
    }
    @Override
    public boolean checkStar(String username,int activityId){
        return userStarRepo.existsByUserNameAndActivityId(username, activityId);
    }

    @Override
    public List<Map<String,Object>> getstarActivities(String userName){
        List<UserStar> userstar = userStarRepo.findAllByUserName(userName);
        List<Integer> collect = userstar.stream().map(UserStar::getActivityId).collect(Collectors.toList());
        return activityRepo.findStarByactivityId(collect);
    }


}
