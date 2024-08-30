package com.nocountry.server.service.impl;

import com.nocountry.server.model.dto.CategoryDTO;
import com.nocountry.server.model.entity.Category;
import com.nocountry.server.repository.CategoryRepository;
import com.nocountry.server.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setDescription(categoryDTO.getDescription());
        System.out.println(categoryDTO.getDescription());
        return categoryRepository.save(category);
    }
}
