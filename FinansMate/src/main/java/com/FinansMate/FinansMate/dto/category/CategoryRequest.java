package com.FinansMate.FinansMate.dto.category;

import com.FinansMate.FinansMate.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CategoryRequest {
    @NotNull
    private Long userId;

    @NotNull
    private String name;

    @NotNull
    private TransactionType category;
}
