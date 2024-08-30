package com.nocountry.server.service;

import com.nocountry.server.model.dto.CategoryDTO;
import com.nocountry.server.model.entity.Category;

public interface ICategory {
    Category createCategory(CategoryDTO categoryDTO);
}
