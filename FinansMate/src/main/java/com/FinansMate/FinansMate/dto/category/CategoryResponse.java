package com.FinansMate.FinansMate.dto.category;

import com.FinansMate.FinansMate.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private Long userId;
    private String name;
    private TransactionType category;
}
