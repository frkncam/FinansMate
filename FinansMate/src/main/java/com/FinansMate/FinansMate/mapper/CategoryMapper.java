package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.category.CategoryRequest;
import com.FinansMate.FinansMate.dto.category.CategoryResponse;
import com.FinansMate.FinansMate.model.Category;
import com.FinansMate.FinansMate.model.MyUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryResponse toResponse(Category category);

    @Mapping(target = "user", source = "user")
    Category toEntity(CategoryRequest request, MyUser user);
}
