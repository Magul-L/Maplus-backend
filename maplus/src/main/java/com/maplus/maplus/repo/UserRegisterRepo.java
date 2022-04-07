package com.maplus.maplus.repo;

import com.maplus.maplus.model.UserRegister;
import com.maplus.maplus.model.UserStar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister,Integer> {
    public List<UserRegister> findAllByUserName(String userName);;
}
