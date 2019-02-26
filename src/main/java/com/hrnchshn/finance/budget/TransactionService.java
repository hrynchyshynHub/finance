package com.hrnchshn.finance.budget;

import com.hrnchshn.finance.auser.AUser;

/**
 * @author ivan.hrynchyshyn
 */
public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto, AUser user);
}
