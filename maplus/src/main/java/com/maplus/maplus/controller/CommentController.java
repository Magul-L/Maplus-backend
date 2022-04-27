package com.maplus.maplus.controller;

import com.maplus.maplus.model.Comment;
import com.maplus.maplus.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping(value = "addComment")
    public ResponseEntity<Integer> addComment(@RequestBody Comment comment){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        comment.setDateTime(dateFormat.format(date));
        Integer id = commentService.addComment(comment);
        return id == null? ResponseEntity.status(HttpStatus.NO_CONTENT).body(null):ResponseEntity.ok(id);
    }

    @GetMapping(value = "getComments/{activityID}")
    public ResponseEntity<List<Object>> getCommentsByActId(@PathVariable("activityID") int id){
        List<Object> list = commentService.getCommentsByActId(id);
        return list==null? ResponseEntity.status(HttpStatus.NO_CONTENT).body(null):ResponseEntity.ok(list);
    }
}
