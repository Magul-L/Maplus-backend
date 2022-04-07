package com.maplus.maplus.repo;

import com.maplus.maplus.model.UserRegister;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister,Integer> {
    public List<UserRegister> findAllByUserName(String userName);
    

    @Transactional
    public boolean deleteAllByUserNameAndActivityId(String userName,int activityId);


    public boolean existsByUserNameAndActivityId(String userName,int activity);
}
