package com.nocountry.server.controller;

import com.nocountry.server.exception.CategoryNotFoundException;
import com.nocountry.server.model.dto.CategoryDTO;
import com.nocountry.server.model.entity.Category;
import com.nocountry.server.service.impl.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categories")
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody @Valid CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    @SecurityRequirements
    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId){
        try{
            return new ResponseEntity<>(categoryService.findCategoryById(categoryId), HttpStatus.OK);
        }catch(CategoryNotFoundException ex){
            return new ResponseEntity<>("There isn't a category with the id: "+ categoryId, HttpStatus.NOT_FOUND);
        }
    }

    @SecurityRequirements
    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        List<Category> categories = categoryService.findAllCategories();
        if(!categories.isEmpty()){
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
        return new ResponseEntity<>("No categories to show", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<?> updateCategory(@RequestBody @Valid CategoryDTO dto, @PathVariable Long categoryId){
        try{
            return new ResponseEntity<>(categoryService.updateCategory(dto, categoryId), HttpStatus.OK);
        }catch(CategoryNotFoundException ex){
            return new ResponseEntity<>("There isn't a category with the id: "+ categoryId, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId){
        boolean isDeleted = categoryService.deleteCategory(categoryId);
        if(isDeleted){
            return new ResponseEntity<>("Category deletion completed successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("There isn't a category with the id: "+ categoryId, HttpStatus.NOT_FOUND);
    }


}
