package com.sampathnuthalapati.blog.Repository;

import com.sampathnuthalapati.blog.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
