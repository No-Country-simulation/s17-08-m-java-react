package com.nocountry.server.model.mappers;

import com.nocountry.server.model.dto.CategoryDTO;
import com.nocountry.server.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO categoryDTO);
}
