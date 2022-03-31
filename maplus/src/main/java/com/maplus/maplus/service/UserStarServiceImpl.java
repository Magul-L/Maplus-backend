package com.maplus.maplus.service;

import com.maplus.maplus.model.UserStar;
import com.maplus.maplus.repo.UserStarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStarServiceImpl implements UserStarService{
    @Autowired
    private UserStarRepo userStarRepo;
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
        try{
            int resultid=userStarRepo.deleteAllByUserNameAndActivityId(username,activityid);
            if(resultid!=-1)
            return true;
            else
                return false;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

    }


}
