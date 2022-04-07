package com.maplus.maplus.controller;


import com.maplus.maplus.model.UserStar;
import com.maplus.maplus.service.UserStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserStarController {
  @Autowired
  private UserStarService userStarService;

    //用户添加收藏
    @GetMapping (value="addStar/{username}/{activityid}")
    public ResponseEntity<Boolean> addStar(@PathVariable("username") String username,@PathVariable("activityid") int activityid) {
        UserStar useritem=new UserStar(username,activityid);
        boolean result= userStarService.addStar(useritem);
        return result ?  ResponseEntity.ok().body(result):ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
    }

    //用户取消收藏
    @GetMapping(value="deleteStar/{username}/{activityid}")
    public ResponseEntity<Boolean> deleteStar(@PathVariable("username") String username,@PathVariable("activityid") int activityid) {
        boolean result= userStarService.deleteStar(username,activityid);
        return result ?  ResponseEntity.ok().body(result):ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
    }
    //检查用户是否收藏了此活动
    @GetMapping(value="checkStar/{username}/{activityid}")
    public boolean checkStar(@PathVariable("username") String username, @PathVariable("activityid") int activityid) {
        return userStarService.checkStar(username,activityid);
            
    }

    //查看收藏的活动
    @GetMapping(value = "Staractivity/{username}")
    public List<Object> getstarActivities(@PathVariable("username") String userName) {
        return userStarService.getstarActivities(userName);
    }


}
