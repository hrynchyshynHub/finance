package com.hrnchshn.finance.budget;

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
        transaction.setCurrencyType(Transaction.CurrencyType.valueOf(transactionDto.getCurrencyType()));
        transaction.setIsIncoming(transactionDto.getIsIncoming());
        transaction.setValue(transactionDto.getValue());
        return transaction;
    }

    @Override
    public TransactionDto doBackward(Transaction transaction) {
        return TransactionDto.builder()
                .id(transaction.getId())
                .currencyType(transaction.getCurrencyType().name())
                .isIncoming(transaction.getIsIncoming())
                .value(transaction.getValue())
                .build();
    }
}
