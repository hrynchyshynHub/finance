package com.hrnchshn.finance.transaction;


import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.auser.AUserRepository;
import com.hrnchshn.finance.budget.Budget;
import com.hrnchshn.finance.budget.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * @author ivan.hrynchyshyn
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final TransactionToTransactionDtoConverter transactionToTransactionDtoConverter;
    private final TransactionToTransactionDtoConverter converter;
    private final BudgetRepository budgetRepository;


    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction newTransaction = converter.doForward(transactionDto, null);
        Budget budget = budgetRepository.findById(transactionDto.getBudgetId())
                        .orElseThrow(EntityNotFoundException::new);
        newTransaction.setBudget(budget);
        return converter.doBackward(newTransaction);
    }

    @Override
    public void updateTransaction(Long id, TransactionDto transactionDto) {
        transactionRepository.findById(id)
                .map(transaction -> transactionToTransactionDtoConverter.doForward(transactionDto, transaction))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
