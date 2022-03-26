package com.maplus.maplus.service;

import com.maplus.maplus.model.User;
import com.maplus.maplus.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public Integer checkUser(String userName){
        Optional<User> isExist = userRepo.findByUserName(userName);
        if (isExist.isPresent()){
            return -1;
        }else{
            return 1;
        }
    }
    @Override
    public Integer saveUser(User user){
        return userRepo.save(user).getUserID();
    }




    
    
}
