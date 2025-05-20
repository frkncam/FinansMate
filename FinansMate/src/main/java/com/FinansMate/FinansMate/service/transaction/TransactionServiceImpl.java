package com.FinansMate.FinansMate.service.transaction;

import com.FinansMate.FinansMate.dto.transaction.TransactionRequest;
import com.FinansMate.FinansMate.dto.transaction.TransactionResponse;
import com.FinansMate.FinansMate.model.Category;
import com.FinansMate.FinansMate.model.MyUser;
import com.FinansMate.FinansMate.model.Transaction;
import com.FinansMate.FinansMate.repository.TransactionRepository;
import com.FinansMate.FinansMate.repository.CategoryRepository;
import com.FinansMate.FinansMate.repository.UserRepository;
import com.FinansMate.FinansMate.mapper.TransactionMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
  //  private final TransactionMapper transactionMapper;

    @Override
    @Transactional
    public TransactionResponse save(TransactionRequest transactionRequest) {

        MyUser user = userRepository.findById(transactionRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

//        Category category = categoryRepository.findById(transactionRequest.getCategoryId())
//                .orElseThrow(() -> new RuntimeException("Category not found"));

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setType(transactionRequest.getType());
        transaction.setDate(transactionRequest.getDate());
        transaction.setDescription(transactionRequest.getDescription());
//        transaction.setCategory(category);
        transaction.setUser(user);
        transaction.setCurrency(transactionRequest.getCurrency());

        transaction = transactionRepository.save(transaction);

      // return transactionMapper.transactionToTransactionResponse(transaction);

        return new TransactionResponse(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getDate(),
                transaction.getDescription(),
                transaction.getCategory().getId(),
                transaction.getUser().getId(),
                transaction.getCurrency()
        );
    }

    @Override
    public List<TransactionResponse> getTransactionsByUserId(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);
        return transactions.stream()
                .map(transaction -> new TransactionResponse(
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getType(),
                        transaction.getDate(),
                        transaction.getDescription(),
                        transaction.getCategory().getId(),
                        transaction.getUser().getId(),
                        transaction.getCurrency()
                ))
                .collect(Collectors.toList());
    }
}
