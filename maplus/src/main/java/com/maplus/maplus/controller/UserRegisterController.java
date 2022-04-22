package com.maplus.maplus.controller;

import com.maplus.maplus.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserRegisterController {
    @Autowired
    private UserRegisterService userRegisterService;

    //用户添加报名
    @GetMapping(value="addRegister/{username}/{activityid}")
    public ResponseEntity<Boolean> addRegister(@PathVariable("username") String username, @PathVariable("activityid") int activityid) {
        boolean result= userRegisterService.addRegister(username,activityid);
        return result ?  ResponseEntity.ok().body(result):ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);


    }
    //用户取消报名
    @GetMapping(value="deleteRegister/{username}/{activityid}")
    public ResponseEntity<Boolean> deleteRegister(@PathVariable("username") String username, @PathVariable("activityid") int activityid) {
        boolean result= userRegisterService.deleteRegister(username,activityid);
        return result ?  ResponseEntity.ok().body(result):ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);


    }
    //检查用户是否报名了此活动
    @GetMapping(value="checkRegister/{username}/{activityid}")
    public boolean checkRegister(@PathVariable("username") String username, @PathVariable("activityid") int activityid) {
        return userRegisterService.checkRegister(username,activityid);
        
    }

    //查看用户报名活动
    @GetMapping(value = "registerActivity/{username}")
    public List<Map<String,Object>> getregisterActivities(@PathVariable("username") String userName) {
        return userRegisterService.getregisterActivities(userName);
    }





}
