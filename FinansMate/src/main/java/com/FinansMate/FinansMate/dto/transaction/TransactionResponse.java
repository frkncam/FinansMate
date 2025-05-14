package com.FinansMate.FinansMate.dto.transaction;
import com.FinansMate.FinansMate.enums.Currency;
import com.FinansMate.FinansMate.enums.TransactionType;
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
public class TransactionResponse {
    private Long id;
    private BigDecimal amount;
    private TransactionType type;
    private LocalDate date;
    private String description;
    //private Long categoryId;
    private Long userId;
    private Currency currency;
}
