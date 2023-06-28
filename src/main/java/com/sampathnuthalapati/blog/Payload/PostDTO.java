package com.sampathnuthalapati.blog.Payload;

import com.sampathnuthalapati.blog.Model.Category;
import com.sampathnuthalapati.blog.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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



}
