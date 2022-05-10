package com.maplus.maplus.service;

import com.maplus.maplus.model.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    public Integer addComment(Comment comment);
    public List<Map<String,Object>> getCommentsByActId(int id);
}
