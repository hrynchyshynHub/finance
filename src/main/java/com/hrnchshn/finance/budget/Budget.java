package com.hrnchshn.finance.budget;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.common.EntityBase;
import com.hrnchshn.finance.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Budget extends EntityBase {
    private CurrencyType currencyType;
    private String name;
    private String description;
    private Double totalAmount = 0d;
    private Double goalAmount = 0d;
    @ManyToOne
    private AUser user;
    @OneToMany
    private List<Transaction> transactions;

    public enum CurrencyType{
        EUR, USD, UAH;
    }

}
