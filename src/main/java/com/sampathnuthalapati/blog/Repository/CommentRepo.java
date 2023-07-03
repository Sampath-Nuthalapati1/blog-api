package com.sampathnuthalapati.blog.Repository;

import com.sampathnuthalapati.blog.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
