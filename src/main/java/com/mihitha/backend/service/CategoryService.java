package com.mihitha.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mihitha.backend.entity.Category;

@Service
public interface CategoryService {

    List<Category> getAllCategories();
    Category findCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    Category deleteCategory(Long id);
    
}
