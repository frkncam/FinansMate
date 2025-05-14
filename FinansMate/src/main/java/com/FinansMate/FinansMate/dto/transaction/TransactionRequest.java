package com.FinansMate.FinansMate.dto.transaction;
import com.FinansMate.FinansMate.enums.Currency;
import com.FinansMate.FinansMate.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    @NotNull
    private BigDecimal amount;

    @NotNull
    private TransactionType type;

    @NotNull
    private LocalDate date;

    private String description;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long userId;

    @NotNull
    private Currency currency;
}
