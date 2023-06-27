package com.sampathnuthalapati.blog.Payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    private Integer catergoryId;
    @NotBlank
    @Size(min = 4, message = "Minimum size of Category Title is 4.")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10)
    private String categoryDescription;
}
