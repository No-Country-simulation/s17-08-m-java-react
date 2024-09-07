package com.nocountry.server.controller;

import com.nocountry.server.exception.CategoryNotFoundException;
import com.nocountry.server.model.dto.CategoryDTO;
import com.nocountry.server.model.entity.Category;
import com.nocountry.server.service.impl.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("arregloYa/v1/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("categories")
    public ResponseEntity<Category> create(@RequestBody @Valid CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    @GetMapping("categories/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId){
        try{
            return new ResponseEntity<>(categoryService.findCategoryById(categoryId), HttpStatus.OK);
        }catch(CategoryNotFoundException ex){
            return new ResponseEntity<>("There isn't a category with the id: "+ categoryId, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("categories")
    public ResponseEntity<?> getAllCategories(){
        List<Category> categories = categoryService.findAllCategories();
        if(!categories.isEmpty()){
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
        return new ResponseEntity<>("No categories to show", HttpStatus.NO_CONTENT);
    }

    @PutMapping("categories/{categoryId}")
    public ResponseEntity<?> updateCategory(@RequestBody @Valid CategoryDTO dto, @PathVariable Long categoryId){
        try{
            return new ResponseEntity<>(categoryService.updateCategory(dto, categoryId), HttpStatus.OK);
        }catch(CategoryNotFoundException ex){
            return new ResponseEntity<>("There isn't a category with the id: "+ categoryId, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("categories/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId){
        boolean isDeleted = categoryService.deleteCategory(categoryId);
        if(isDeleted){
            return new ResponseEntity<>("Category deletion completed successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("There isn't a category with the id: "+ categoryId, HttpStatus.NOT_FOUND);
    }


}
