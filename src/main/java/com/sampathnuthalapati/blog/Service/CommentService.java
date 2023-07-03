package com.sampathnuthalapati.blog.Service;

import com.sampathnuthalapati.blog.Payload.CommentDTO;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO, Integer postId);

    void deleteComment(Integer commentId);
}
