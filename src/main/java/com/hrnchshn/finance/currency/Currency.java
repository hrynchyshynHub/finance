package com.hrnchshn.finance.currency;

import com.hrnchshn.finance.common.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @author ivan.hrynchyshyn
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Currency extends EntityBase {
    private Float usdValueSale;
    private Float usdValueBuy;
    private Float eurValueSale;
    private Float eurValueBuy;
}
