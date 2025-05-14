package com.FinansMate.FinansMate.mapper;

import com.FinansMate.FinansMate.dto.transaction.TransactionRequest;
import com.FinansMate.FinansMate.dto.transaction.TransactionResponse;
import com.FinansMate.FinansMate.model.Transaction;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T16:32:05+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionResponse transactionToTransactionResponse(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionResponse transactionResponse = new TransactionResponse();

        transactionResponse.setId( transaction.getId() );
        transactionResponse.setAmount( transaction.getAmount() );
        transactionResponse.setType( transaction.getType() );
        transactionResponse.setDate( transaction.getDate() );
        transactionResponse.setDescription( transaction.getDescription() );
        transactionResponse.setCurrency( transaction.getCurrency() );

        return transactionResponse;
    }

    @Override
    public Transaction transactionRequestToTransaction(TransactionRequest transactionRequest) {
        if ( transactionRequest == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setAmount( transactionRequest.getAmount() );
        transaction.setType( transactionRequest.getType() );
        transaction.setDate( transactionRequest.getDate() );
        transaction.setDescription( transactionRequest.getDescription() );
        transaction.setCurrency( transactionRequest.getCurrency() );

        return transaction;
    }
}
