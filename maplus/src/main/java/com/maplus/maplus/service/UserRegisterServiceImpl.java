package com.maplus.maplus.service;

import com.maplus.maplus.model.Activity;
import com.maplus.maplus.model.UserRegister;
import com.maplus.maplus.model.UserStar;
import com.maplus.maplus.repo.ActivityRepo;
import com.maplus.maplus.repo.UserRegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
            activityRepo.addRegistryNum(activityid);
            UserRegister item=new UserRegister(username,activityid);
            userRegisterRepo.save(item);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Object> getregisterActivities(String userName) {
        List<UserRegister> userRegisters = userRegisterRepo.findAllByUserName(userName);
        List<Integer> collect = userRegisters.stream().map(UserRegister::getActivityId).collect(Collectors.toList());
        return activityRepo.findregisterByactivityId(collect);
    }


}
