package com.maplus.maplus.repo;

import com.maplus.maplus.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {

    @Query(value = "SELECT c.user_name as user_name, c.comtext as comtext, c.date_time as date_time FROM comment as c WHERE c.activityid = :actID ORDER BY c.date_time ",nativeQuery = true)
    List<Map<String,Object>> findByActivityID(int actID);
}
