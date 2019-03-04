package com.hrnchshn.finance.transaction;

import com.hrnchshn.finance.common.EntityToDtoConverter;
import org.springframework.stereotype.Component;

import java.time.Month;
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
        transaction.setNote(transactionDto.getNote());
        transaction.setValue(transactionDto.getIsIncoming() ? transactionDto.getValue() : 0 - transactionDto.getValue());
        return transaction;
    }

    @Override
    public TransactionDto doBackward(Transaction transaction) {
        Integer dayOfMonth = transaction.getCreated().toLocalDateTime().getDayOfMonth();
        Month month = transaction.getCreated().toLocalDateTime().getMonth();
        return TransactionDto.builder()
                .budgetId(transaction.getBudget().getId())
                .id(transaction.getId())
                .created(month.name().toLowerCase() + " " + dayOfMonth)
                .note(transaction.getNote())
                .isIncoming(transaction.getIsIncoming())
                .value(transaction.getValue())
                .build();
    }
}
