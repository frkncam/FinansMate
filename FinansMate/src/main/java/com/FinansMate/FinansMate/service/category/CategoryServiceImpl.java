package com.FinansMate.FinansMate.service.impl;

import com.FinansMate.FinansMate.dto.category.CategoryRequest;
import com.FinansMate.FinansMate.dto.category.CategoryResponse;
import com.FinansMate.FinansMate.mapper.CategoryMapper;
import com.FinansMate.FinansMate.model.Category;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.repository.CategoryRepository;
import com.FinansMate.FinansMate.repository.UserRepository;
import com.FinansMate.FinansMate.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper mapper;

    @Override
    @Transactional
    public CategoryResponse saveCategory(CategoryRequest req) {
        MyUser user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Category entity = mapper.toEntity(req, user);
        Category saved = categoryRepository.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public List<CategoryResponse> getCategoriesByUser(Long userId) {
        return categoryRepository.findAll().stream()
                .filter(c -> c.getUser().getId().equals(userId))
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
