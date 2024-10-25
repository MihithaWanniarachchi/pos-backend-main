package com.mihitha.backend.service.impl;

import java.util.List;

import com.mihitha.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mihitha.backend.entity.Category;
import com.mihitha.backend.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category){
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }else{
            return null;
        }
    }

    @Override
    public Category deleteCategory(Long id){
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            categoryRepository.deleteById(id);
            return existingCategory;
        }
        throw new EntityNotFoundException("There is no item category associated with the id"+id);
    
    }
    
}
