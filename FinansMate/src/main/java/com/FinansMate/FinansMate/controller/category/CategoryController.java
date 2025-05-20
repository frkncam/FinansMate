package com.FinansMate.FinansMate.controller.category;
import com.FinansMate.FinansMate.dto.category.CategoryRequest;
import com.FinansMate.FinansMate.dto.category.CategoryResponse;
import com.FinansMate.FinansMate.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public CategoryResponse create(@RequestBody @Valid CategoryRequest req) {
        return service.saveCategory(req);
    }

    @GetMapping("/user/{userId}")
    public List<CategoryResponse> listByUser(@PathVariable Long userId) {
        return service.getCategoriesByUser(userId);
    }
}
