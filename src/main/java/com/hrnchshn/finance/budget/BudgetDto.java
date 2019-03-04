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
public class BudgetDto {
    private Long id;
    private String currencyType;
    private String name;
    private String description;
    private Double totalAmount;
    private Double goalAmount;
}
