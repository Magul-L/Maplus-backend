package com.maplus.maplus.controller;

import com.maplus.maplus.model.User;
import com.maplus.maplus.repo.UserRepo;
import com.maplus.maplus.service.UserService;
import com.maplus.maplus.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    //用户注册
    @PostMapping(value = "userRegister")
    public ResponseEntity<Integer> userRegister(@RequestBody User user){
        Integer id =userService.userRegister(user);
        return id == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(null) : ResponseEntity.ok().body(id);

    }

}
