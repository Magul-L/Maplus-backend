package com.maplus.maplus.repo;


import com.maplus.maplus.model.Activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Integer> {
    @Transactional
    @Modifying
    @Query(value="update activity set activity.activity_desc= :desc," +
            "activity.activity_title= :title," +
            "activity.begin_time= :bgtime," +
            "activity.building= :actybd," +
            "activity.club_name= :clubname," +
            "activity.end_time= :endtime," +
            "activity.estimate_num= :estnum," +
            "activity.publisher= :publisher," +
            "activity.room= :room," +
            "activity.target_people= :tarpeople," +
            "activity.activity_detail= :actdetail where activity.activityid= :actid",nativeQuery = true)
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
                               @Param("actid") int actid );


    @Transactional
    @Modifying
    @Query(value="update activity set activity.hot=hot+1 where activity.activityid= :actid",nativeQuery = true)
    public void addHot(@Param("actid") int actid);

}

