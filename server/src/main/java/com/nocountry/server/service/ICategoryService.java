package com.nocountry.server.service;

import com.nocountry.server.model.dto.CategoryDTO;
import com.nocountry.server.model.entity.Category;
import com.nocountry.server.service.impl.CategoryService;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDTO categoryDTO);

    Category findCategoryById(Long categoryId);

    List<Category> findAllCategories();

    Category updateCategory(CategoryDTO categoryDTO, Long categoryId);

    boolean deleteCategory(Long categoryId);

}
