package com.nocountry.server.service.impl;

import com.nocountry.server.exception.CategoryNotFoundException;
import com.nocountry.server.model.dto.CategoryDTO;
import com.nocountry.server.model.entity.Category;
import com.nocountry.server.repository.CategoryRepository;
import com.nocountry.server.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setDescription(categoryDTO.getDescription());
        log.info("New category created with the description:{}", categoryDTO.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("There isn't a category with the id: "+ categoryId));
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        if(categoryRepository.existsById(categoryId)){
            Category oldCategory = findCategoryById(categoryId);
            oldCategory.setDescription(categoryDTO.getDescription());
            log.info("The category has been updated, category id:{}", categoryId);
            return categoryRepository.save(oldCategory);
        }
        log.error("category update failed, there isn't a category with the id:{}", categoryId);
        throw new CategoryNotFoundException("There isn't a category with the id: "+ categoryId);
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        if(categoryRepository.existsById(categoryId)){
            categoryRepository.deleteById(categoryId);
            log.info("deletion successfully, category id:{}", categoryId);
            return true;
        }
        log.error("category deletion failed, there isn't a category with the id:{}", categoryId);
        return false;
        }
    }

