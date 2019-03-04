package com.hrnchshn.finance.transaction;


import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
    void updateTransaction(Long id, TransactionDto transactionDto);
    void deleteTransaction(Long id);
    List<TransactionDto> getTransactions();
}
