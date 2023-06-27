package com.sampathnuthalapati.blog.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catergoryId;

    @Column(name="title", length=100, nullable = false)
    private String categoryTitle;
    @Column(name="description")
    private String categoryDescription;
}
