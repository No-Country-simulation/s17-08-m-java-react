package com.nocountry.server.controller;

import com.nocountry.server.model.dto.CategoryDTO;
import com.nocountry.server.model.entity.Category;
import com.nocountry.server.service.impl.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("arregloYa/v1/categories/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("create")
    public Category create(@RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }
}
