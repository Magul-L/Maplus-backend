package com.maplus.maplus.service;

import com.maplus.maplus.model.Comment;
import com.maplus.maplus.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public Integer addComment(Comment comment){
        return commentRepo.save(comment).getComID();
    }

    @Override
    public List<Object> getCommentsByActId(int id){
        return commentRepo.findByActivityID(id);
    }
}
