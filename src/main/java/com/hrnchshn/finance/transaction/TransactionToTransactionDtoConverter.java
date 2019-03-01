package com.hrnchshn.finance.transaction;

import com.hrnchshn.finance.common.EntityToDtoConverter;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author ivan.hrynchyshyn
 */
@Component
public class TransactionToTransactionDtoConverter implements EntityToDtoConverter<Transaction, TransactionDto> {
    @Override
    public Transaction doForward(TransactionDto transactionDto, Transaction transaction) {
        transaction = Optional.ofNullable(transaction)
                              .orElse(new Transaction());
        transaction.setIsIncoming(transactionDto.getIsIncoming());
        transaction.setValue(transactionDto.getIsIncoming() ? transactionDto.getValue() : 0 - transactionDto.getValue());
        return transaction;
    }

    @Override
    public TransactionDto doBackward(Transaction transaction) {
        return TransactionDto.builder()
                .budgetId(transaction.getBudget().getId())
                .id(transaction.getId())
                .isIncoming(transaction.getIsIncoming())
                .value(transaction.getValue())
                .build();
    }
}
