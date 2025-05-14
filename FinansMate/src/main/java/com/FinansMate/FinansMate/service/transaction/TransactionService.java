package com.FinansMate.FinansMate.service.transaction;

import com.FinansMate.FinansMate.dto.transaction.TransactionRequest;
import com.FinansMate.FinansMate.dto.transaction.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionResponse save(TransactionRequest transactionRequest);
    List<TransactionResponse> getTransactionsByUserId(Long userId);
}
