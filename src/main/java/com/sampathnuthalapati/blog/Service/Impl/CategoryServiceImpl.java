package com.sampathnuthalapati.blog.Service.Impl;

import com.sampathnuthalapati.blog.Exception.ResourceNotFoundException;
import com.sampathnuthalapati.blog.Model.Category;
import com.sampathnuthalapati.blog.Payload.CategoryDTO;
import com.sampathnuthalapati.blog.Repository.CategoryRepo;
import com.sampathnuthalapati.blog.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = this.modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = this.categoryRepo.save(category);

        return this.modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        Category updatedCategory = this.categoryRepo.save(category);

        return this.modelMapper.map(updatedCategory, CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category ID", categoryId));

        return this.modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDTO> categoryDTOs = categories.stream().map((category) -> this.modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
        return categoryDTOs;
    }
}
