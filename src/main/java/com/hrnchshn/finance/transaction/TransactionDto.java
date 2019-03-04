package com.hrnchshn.finance.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ivan.hrynchyshyn
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private Long budgetId;
    private Double value;
    private String note;
    private Boolean isIncoming;
    private String created;
}
