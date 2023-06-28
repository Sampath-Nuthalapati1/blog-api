package com.sampathnuthalapati.blog.Service;

import com.sampathnuthalapati.blog.Model.Post;
import com.sampathnuthalapati.blog.Payload.PostDTO;
import com.sampathnuthalapati.blog.Payload.PostResponse;

import java.util.List;

public interface PostService {
    //create
    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);

    //update
    PostDTO updatePost(PostDTO postDTO, Integer postId);

    //delete
    void deletePost(Integer postId);

    //getAll
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);

    //get
    PostDTO getPostById(Integer postId);

    //get all posts by Category
    List<PostDTO> getPostsByCategory(Integer categoryId);

    //get all posts by user
    List<PostDTO> getPostsByUser(Integer userId);

    //search posts using keyword
    List<Post> searchPosts(String keyword);


}
