package com.sampathnuthalapati.blog.Repository;

import com.sampathnuthalapati.blog.Model.Category;
import com.sampathnuthalapati.blog.Model.Post;
import com.sampathnuthalapati.blog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);


}
