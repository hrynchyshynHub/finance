package com.hrnchshn.finance.transaction;

import com.hrnchshn.finance.budget.Budget;
import com.hrnchshn.finance.common.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author ivan.hrynchyshyn
 */
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Transaction extends EntityBase {
    private Double value;
    private Boolean isIncoming;
    private String note;
    @ManyToOne
    private Budget budget;

    @PrePersist
    @PreUpdate
    public void recalculateBudgetTotal(){
        budget.setTotalAmount(budget.getTransactions().stream().mapToDouble(Transaction::getValue).sum());
    }
}
