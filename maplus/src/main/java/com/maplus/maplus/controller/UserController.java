package com.maplus.maplus.controller;

import com.maplus.maplus.model.User;
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

    private UserService userService;

    //用户名查重
    @PostMapping(value = "userCheck/{userName}")
    public Integer checkUser(@PathVariable("userName") String userName){
        return userService.checkUser(userName);
    }
    //用户注册
    @PostMapping(value = "userRegister")
    public Integer saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    //用户登录
    @PostMapping(value = "login/{userName}/{userPassword}")
    public int login(@PathVariable("userName") String username, @PathVariable("userPassword") String userpassword){

        return userService.login(username,userpassword);
    }

    //修改密码
    //在url后加userName和userPassword和newPassword
    @PostMapping(value = "changePsw/{userName}/{userPassword}/{newPassword}")
    public boolean modifyPsw(@PathVariable("userName") String username, @PathVariable("userPassword") String userpassword, @PathVariable("newPassword") String newpassword) {
        boolean changePswResult = userService.changePsw(username,userpassword,newpassword);
        return changePswResult;
//                changePswResult?ResponseEntity.ok().body(changePswResult):ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);


    }



    //修改昵称
    //只需在url后添加username和nickname,不需要传入整个user
    @PostMapping(value = "changeNickname/{userName}/{userNickname}")
    public ResponseEntity<Boolean> modifyActivity(@PathVariable("userName") String username, @PathVariable("userNickname") String usernickname) {
        boolean changeNickResult = userService.userChangeNickname(username,usernickname);
        return changeNickResult?ResponseEntity.ok().body(changeNickResult):ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
    }



}



