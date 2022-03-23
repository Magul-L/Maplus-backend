package com.maplus.maplus.controller;

import com.maplus.maplus.model.Activity;
import com.maplus.maplus.model.User;
import com.maplus.maplus.repo.UserRepo;
import com.maplus.maplus.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;
    //用户注册
    @PostMapping(value = "userRegister")
    public boolean saveActivity(@RequestBody User user) {
        userRepo.save(user);
        return true;
    }
    //修改昵称
    //只需在url后添加username和nickname,不需要传入整个user
    @PostMapping(value = "changeNickname/{userName}/{userNickname}")
    public ResponseEntity<Boolean> modifyActivity(@PathVariable("userName") String username, @PathVariable("userNickname") String usernickname) {
        boolean changeNickResult = userService.userChangeNickname(username,usernickname);
        return changeNickResult?ResponseEntity.ok().body(changeNickResult):ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
    }


}
