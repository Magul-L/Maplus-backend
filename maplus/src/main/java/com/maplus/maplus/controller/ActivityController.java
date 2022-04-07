package com.maplus.maplus.controller;


import com.maplus.maplus.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;    ///1111
import com.maplus.maplus.model.Activity;


import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    //url:.../activity
//get 
//返回所有activity的简略信息
    @GetMapping(value = "activity")
    public ResponseEntity<List<Object>> getActivities() {
        List<Object> list = activityService.getActivities();
        return list == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(null) : ResponseEntity.ok().body(list);
    }


    

    //url:.../createActivity
//post 输入activity除id的信息，hot，registyNum前端默认为0，estimateNum前端默认为无限
//返回id
    @PostMapping(value = "createActivity")
    public ResponseEntity<Integer> saveActivity(@RequestBody Activity activity) {
        Integer id = activityService.saveActivity(activity);
        return id == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(null) : ResponseEntity.ok().body(id);
    }

//url:.../deleteActivity
//post 输入id
//返回删除成功 or 失败
    @GetMapping(value = "deleteActivity/{id}")                          //get 输入id
    public ResponseEntity<Boolean> deleteActvity(@PathVariable("id") int id) {
        boolean isSuccess = activityService.deleteActvity(id);
        return isSuccess ? ResponseEntity.ok().body(isSuccess):ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
    }

//url:.../preModifyActivity/id
//get
//返回activity信息
    @GetMapping(value = "preModifyActivity/{id}")
    public ResponseEntity<Activity> getActivity(@PathVariable("id") int id) {
        Activity activity = activityService.getActivity(id);
        return activity==null?ResponseEntity.status(HttpStatus.NO_CONTENT).body(null):ResponseEntity.ok().body(activityService.getActivity(id));
    }


    //url:.../submitModifyActivity/oldId
//post 输入activity除id的信息，hot，registyNum前端默认为0，estimateNum前端默认为无限
//返回新的id
    @PostMapping(value = "submitModifyActivity/{id}")
    public ResponseEntity<Integer> modifyActivity(@PathVariable("id") int id, @RequestBody Activity activity) {
        int newId = activityService.modifyActivity(id,activity);
        return newId==-1?ResponseEntity.status(HttpStatus.NO_CONTENT).body(null):ResponseEntity.ok().body(newId);
    }

    //加热度
    //url:.../addHot
    //返回新热度
    @GetMapping(value = "addHot/{id}")
    public int addHot(@PathVariable("id") int id) {
        int hot = activityService.Hot(id);
        return hot;
    }

    //搜索
    @GetMapping(value="searchActivity/{content}")
    public ResponseEntity<List<Object>> searchActivity(@PathVariable("content") String content){
        return activityService.searchActivity(content).size()==0?ResponseEntity.status(HttpStatus.NO_CONTENT).body(null):ResponseEntity.ok().body(activityService.searchActivity(content));
    }




}
