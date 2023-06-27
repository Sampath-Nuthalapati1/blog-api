package com.sampathnuthalapati.blog.Controller;

import com.sampathnuthalapati.blog.Payload.APIRespnse;
import com.sampathnuthalapati.blog.Payload.CategoryDTO;
import com.sampathnuthalapati.blog.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // createCategory
    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO createCategory = this.categoryService.createCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(createCategory, HttpStatus.CREATED);
    }

    // updateCategory
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryId) {
        CategoryDTO updatedCategory = this.categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<CategoryDTO>(updatedCategory, HttpStatus.OK);
    }

    // deleteCategory
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<APIRespnse> deleteCategory(@PathVariable Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<APIRespnse>(new APIRespnse("Category delted succesffuly",true), HttpStatus.OK);
    }

    // getCategory
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory( @PathVariable Integer categoryId) {
        CategoryDTO category = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<CategoryDTO>(category, HttpStatus.OK);
    }

    // getALL
    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
}
