package com.sampathnuthalapati.blog.Controller;

import com.sampathnuthalapati.blog.Payload.APIRespnse;
import com.sampathnuthalapati.blog.Payload.CommentDTO;
import com.sampathnuthalapati.blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO, @PathVariable Integer postId) {
        CommentDTO createdComment = this.commentService.createComment(commentDTO, postId);
        return new ResponseEntity<CommentDTO>(createdComment, HttpStatus.CREATED);

    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<APIRespnse> deleteComment(@PathVariable Integer postId) {
        this.commentService.deleteComment(postId);
        return new ResponseEntity<APIRespnse>(new APIRespnse("Comment deleted successfully", true), HttpStatus.OK);

    }



}
