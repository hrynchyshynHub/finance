package com.hrnchshn.finance.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UaBankResponseElement {
    private String date;
    private String bankName;
    private String sourceUrl;
    private String codeNumeric;
    private String codeAlpha;
    private String rateBuy;
    private String rateBuyDelta;
    private String rateSale;
    private String rateSaleDelta;
}
