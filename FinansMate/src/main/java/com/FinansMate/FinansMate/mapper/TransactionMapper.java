package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.transaction.TransactionRequest;
import com.FinansMate.FinansMate.dto.transaction.TransactionResponse;
import com.FinansMate.FinansMate.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    // Transaction Entity to TransactionResponse DTO
    TransactionResponse transactionToTransactionResponse(Transaction transaction);

    // TransactionRequest DTO to Transaction Entity
    Transaction transactionRequestToTransaction(TransactionRequest transactionRequest);
}