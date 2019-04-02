package com.hrnchshn.finance.transformers;

import com.hrnchshn.finance.service.currencies.dto.CurrencyModel;
import com.hrnchshn.finance.service.currencies.dto.UaBankResponseElement;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.hrnchshn.finance.constants.Api.EUR;
import static com.hrnchshn.finance.constants.Api.PRIVAT_BANK;
import static com.hrnchshn.finance.constants.Api.USD;

@Component
public class BankUaToCurrencyModelTransformer {

    public CurrencyModel backWard(List<UaBankResponseElement> uaBankResponseElement) {

        CurrencyModel model = new CurrencyModel();

        for (UaBankResponseElement element : uaBankResponseElement) {
            if (element.getSourceUrl().equals(PRIVAT_BANK)) {
                switch (element.getCodeAlpha()) {
                    case USD:
                        model.setUsdValueBuy((element.getRateBuy()));
                        model.setUsdValueSale(element.getRateSale());
                        break;
                    case EUR:
                        model.setEurValueBuy(element.getRateBuy());
                        model.setEurValueSale(element.getRateSale());
                        break;
                    default:
                        break;
                }
            }
        }
        return model;
    }
}
