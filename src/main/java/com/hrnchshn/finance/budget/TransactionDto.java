package com.hrnchshn.finance.budget;

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
    private Double value;
    private Boolean isIncoming;
    private String currencyType;
}
