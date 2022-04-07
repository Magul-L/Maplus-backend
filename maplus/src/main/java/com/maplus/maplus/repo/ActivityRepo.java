package com.maplus.maplus.repo;


import java.util.List;

import com.maplus.maplus.model.Activity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update activity set activity.activity_desc= :desc," +
            "activity.activity_title= :title," +
            "activity.begin_time= :bgtime," +
            "activity.building= :actybd," +
            "activity.club_name= :clubname," +
            "activity.end_time= :endtime," +
            "activity.estimate_num= :estnum," +
            "activity.publisher= :publisher," +
            "activity.room= :room," +
            "activity.target_people= :tarpeople," +
            "activity.activity_detail= :actdetail where activity.activityid= :actid", nativeQuery = true)
    public void updateActivity(@Param("desc") String desc,
                               @Param("title") String title,
                               @Param("bgtime") String bgtime,
                               @Param("actybd") String actybd,
                               @Param("clubname") String clubname,
                               @Param("endtime") String endtime,
                               @Param("estnum") int estnum,
                               @Param("publisher") String publisher,
                               @Param("room") String room,
                               @Param("tarpeople") String tarpeople,
                               @Param("actdetail") String actdetail,
                               @Param("actid") int actid);






    @Transactional
    @Modifying
    @Query(value = "update activity set activity.hot=hot+1 where activity.activityid= :actid", nativeQuery = true)
    public void addHot(@Param("actid") int actid);

    @Transactional
    @Modifying
    @Query(value = "update activity set activity.registry_num=registry_num+1 where activity.activityid= :actid", nativeQuery = true)
    public void addRegistryNum(@Param("actid") int actid);
    
    @Query(value = "SELECT a.activityid as activityid, a.activity_title as activity_title, a.activity_desc as activity_desc,a.hot as hot FROM activity a WHERE a.activity_title LIKE CONCAT('%',:content,'%') OR a.activity_desc LIKE CONCAT('%',:content,'%')",nativeQuery = true)
    public List<Object> searchActivity(String content);

    @Query(value = "select a.activityid as activityid, a.activity_title as activity_title, a.activity_desc as activity_desc from activity a", nativeQuery = true)
    List<Object> findIntro();

    @Query(value = "select a.activityid as activityid, a.activity_title as activity_title, a.activity_desc as activity_desc from activity a where a.activityid in(:activityId)",nativeQuery = true)
    List<Object> findStarByactivityId(List<Integer> activityId);

    @Query(value = "select a.activityid as activityid, a.activity_title as activity_title, a.activity_desc as activity_desc from activity a where a.activityid in(:activityId)",nativeQuery = true)
    List<Object> findregisterByactivityId(List<Integer> activityId);



}



