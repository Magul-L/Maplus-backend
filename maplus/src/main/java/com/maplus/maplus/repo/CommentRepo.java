package com.maplus.maplus.repo;

import com.maplus.maplus.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {

    @Query(value = "SELECT c.user_name as user_name, c.comtext as comtext FROM comment as c WHERE c.activityid = :actID",nativeQuery = true)
    List<Object> findByActivityID(int actID);
}
