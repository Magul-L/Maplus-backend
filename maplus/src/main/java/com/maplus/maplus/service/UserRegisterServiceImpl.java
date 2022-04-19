package com.maplus.maplus.service;


import com.maplus.maplus.model.UserRegister;

import com.maplus.maplus.repo.ActivityRepo;
import com.maplus.maplus.repo.UserRegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{
    @Autowired
    private UserRegisterRepo userRegisterRepo;
    @Autowired
    private ActivityRepo activityRepo;

    @Override
    public boolean addRegister(String username,int activityid){
        try{
            if(!checkRegister(username,activityid)){
            activityRepo.addRegistryNum(activityid);
            UserRegister item=new UserRegister(username,activityid);
            userRegisterRepo.save(item);
            return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteRegister(String username, int activityid){
     try{
         if(checkRegister(username,activityid)){
         userRegisterRepo.deleteAllByUserNameAndActivityId(username, activityid);
         activityRepo.deleteRegistryNum(activityid);
         return true;
        }else{
            return false;
        }
    }
        
    
    catch(Exception e){
        return false;
    }
} 

    @Override
    public boolean checkRegister(String username,int activityId){
        return userRegisterRepo.existsByUserNameAndActivityId(username, activityId);
    }


    @Override
    public List<Map<String,Object>> getregisterActivities(String userName) {
        List<UserRegister> userRegisters = userRegisterRepo.findAllByUserName(userName);
        List<Integer> collect = userRegisters.stream().map(UserRegister::getActivityId).collect(Collectors.toList());
        return activityRepo.findregisterByactivityId(collect);
    }


}
