package com.hrnchshn.finance.transaction;


/**
 * @author ivan.hrynchyshyn
 */
public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
    void updateTransaction(Long id, TransactionDto transactionDto);
    void deleteTransaction(Long id);
}
