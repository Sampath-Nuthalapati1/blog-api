package com.sampathnuthalapati.blog.Service.Impl;

import com.sampathnuthalapati.blog.Exception.ResourceNotFoundException;
import com.sampathnuthalapati.blog.Model.Category;
import com.sampathnuthalapati.blog.Model.Post;
import com.sampathnuthalapati.blog.Model.User;
import com.sampathnuthalapati.blog.Payload.PostDTO;
import com.sampathnuthalapati.blog.Payload.PostResponse;
import com.sampathnuthalapati.blog.Repository.CategoryRepo;
import com.sampathnuthalapati.blog.Repository.PostRepo;
import com.sampathnuthalapati.blog.Repository.UserRepo;
import com.sampathnuthalapati.blog.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));


        Post post = this.modelMapper.map(postDTO, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);


        return this.modelMapper.map(newPost, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));

        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        post.setImageName(postDTO.getImageName());

        Post updatedPost = this.postRepo.save(post);


        return this.modelMapper.map(updatedPost, PostDTO.class);
    }



    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
        this.postRepo.delete(post);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection) {

        Sort sort = (sortDirection.equals("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

//        Sort sort = null;
//        if(sortDirection.equals("asc")) {
//            sort=Sort.by(sortBy).ascending();
//        }
//        else {
//            sort=Sort.by(sortBy).descending();
//        }
        Pageable p = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> pagePost= this.postRepo.findAll(p);
        List<Post> posts = pagePost.getContent();
        List<PostDTO> postDTOs = posts.stream().map((post -> this.modelMapper.map(post, PostDTO.class))).collect(Collectors.toList());

        PostResponse postResponse= new PostResponse();
        postResponse.setContent(postDTOs);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());
        return postResponse;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
        return this.modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostsByCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));
        List<Post> posts = this.postRepo.findByCategory(category);


        List<PostDTO> postDTOs = posts.stream().map((post -> this.modelMapper.map(post, PostDTO.class))).collect(Collectors.toList());

        return postDTOs;
    }

    @Override
    public List<PostDTO> getPostsByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        List<Post> posts = this.postRepo.findByUser(user);

        List<PostDTO> postDTOs = posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());

        return postDTOs;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
