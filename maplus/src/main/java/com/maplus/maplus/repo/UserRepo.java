package com.maplus.maplus.repo;

import com.maplus.maplus.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);

    Optional<User> findByUserPassword(String userPassword);
    public boolean existsByUserName(String userName);
    public boolean existsByUserPassword(String userPassword);

    @Transactional
    @Modifying
    @Query(value="update user set user.user_password= :newpassword where user.user_name= :username AND user.user_password= :userpassword",nativeQuery = true)
    public void updatePsw(@Param("username") String username, @Param("userpassword") String userpassword, @Param("newpassword") String newpassword);





    @Transactional
    @Modifying
    @Query(value="update user set user.user_nickname= :nickname where user.user_name= :username",nativeQuery = true)
    public void updateNickname(@Param("username") String username, @Param("nickname") String nickname);
}

