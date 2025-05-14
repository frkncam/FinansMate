package com.FinansMate.FinansMate.controller.transaction;

import com.FinansMate.FinansMate.dto.transaction.TransactionRequest;
import com.FinansMate.FinansMate.dto.transaction.TransactionResponse;
import com.FinansMate.FinansMate.service.transaction.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/create")
    public TransactionResponse createTransaction(@RequestBody @Valid TransactionRequest transactionRequest) {
        return transactionService.save(transactionRequest);
    }

    @GetMapping("/user/{userId}")
    public List<TransactionResponse> getTransactionsByUserId(@PathVariable Long userId) {
        return transactionService.getTransactionsByUserId(userId);
    }
}