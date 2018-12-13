package com.hrnchshn.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyModel {
    private String usdValueSale;
    private String usdValueBuy;
    private String eurValueSale;
    private String eurValueBuy;
}
