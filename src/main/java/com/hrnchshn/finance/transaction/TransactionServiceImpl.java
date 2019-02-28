package com.hrnchshn.finance.transaction;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.auser.AUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ivan.hrynchyshyn
 */
@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionToTransactionDtoConverter converter;
    @Autowired
    private AUserRepository userRepository;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto, AUser user) {
        Transaction newTransaction = converter.doForward(transactionDto, null);
        user.getTransactions().add(newTransaction);
        userRepository.save(user);
        return converter.doBackward(newTransaction);
    }
}
