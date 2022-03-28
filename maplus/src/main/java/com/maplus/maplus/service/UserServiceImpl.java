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

    @Override
    public boolean login(User user) {
        Optional<User> userNameExist = userRepo.findByUserName(user.getUserName());
        Optional<User> userPasswordExist = userRepo.findByUserPassword(user.getUserPassword());
        if(userNameExist.isPresent() && userPasswordExist.isPresent()){
            return true;
        }else{
        return false;
        }

    }
            



    @Override
    public boolean userChangeNickname(String username,String usernickname){
        if(userRepo.existsByUserName(username)){
            userRepo.updateNickname(username,usernickname);

            return true;
        }else{
        return false;
        }
    }

    @Override
    public boolean changePsw(String username, String userpassword,String newpassword){
        if (userRepo.existsByUserName(username)&userRepo.existsByUserPassword(userpassword)) {
                userRepo.updatePsw(username, userpassword, newpassword);
                return true;
        }
else{
        return false;
        }

    }

    


}
}

