package com.sampathnuthalapati.blog.Service.Impl;

import com.sampathnuthalapati.blog.Exception.ResourceNotFoundException;
import com.sampathnuthalapati.blog.Model.Comment;
import com.sampathnuthalapati.blog.Model.Post;
import com.sampathnuthalapati.blog.Payload.CommentDTO;
import com.sampathnuthalapati.blog.Repository.CommentRepo;
import com.sampathnuthalapati.blog.Repository.PostRepo;
import com.sampathnuthalapati.blog.Service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));

        Comment comment = this.modelMapper.map(commentDTO, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDTO.class);


    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment Id", commentId));
        this.commentRepo.delete(comment);
    }
}
