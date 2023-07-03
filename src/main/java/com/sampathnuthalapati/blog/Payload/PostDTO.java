package com.sampathnuthalapati.blog.Payload;

import com.sampathnuthalapati.blog.Model.Category;
import com.sampathnuthalapati.blog.Model.Comment;
import com.sampathnuthalapati.blog.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private Integer Id;
    private String title;
    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDTO category;

    private UserDTO user;

    private Set<CommentDTO> comments = new HashSet<>();



}
