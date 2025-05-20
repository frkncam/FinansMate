package com.FinansMate.FinansMate.service;

import com.FinansMate.FinansMate.dto.category.CategoryRequest;
import com.FinansMate.FinansMate.dto.category.CategoryResponse;
import java.util.List;

public interface CategoryService {
    CategoryResponse saveCategory(CategoryRequest request);
    List<CategoryResponse> getCategoriesByUser(Long userId);
}
