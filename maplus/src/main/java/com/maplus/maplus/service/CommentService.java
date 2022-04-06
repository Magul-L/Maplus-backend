package com.maplus.maplus.service;

import com.maplus.maplus.model.Comment;

import java.util.List;

public interface CommentService {
    public Integer addComment(Comment comment);
    public List<Object> getCommentsByActId(int id);
}
