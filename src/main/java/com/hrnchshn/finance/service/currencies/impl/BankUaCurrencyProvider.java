package com.hrnchshn.finance.service.currencies.impl;

import com.google.gson.Gson;
import com.hrnchshn.finance.currency.Currency;
import com.hrnchshn.finance.currency.CurrencyRepository;
import com.hrnchshn.finance.service.currencies.CurrencyProvider;
import com.hrnchshn.finance.service.currencies.dto.CurrencyModel;
import com.hrnchshn.finance.service.currencies.dto.UaBankResponseElement;
import com.hrnchshn.finance.transformers.BankUaToCurrencyModelTransformer;
import com.hrnchshn.finance.utils.WebCall;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Arrays;

import static com.hrnchshn.finance.constants.Api.UA_BANK_API;

@Component
@RequiredArgsConstructor
public class BankUaCurrencyProvider implements CurrencyProvider {

    private final BankUaToCurrencyModelTransformer transformer;
    private final CurrencyRepository currencyRepository;

    public CurrencyModel getCurrency(){
        CurrencyModel currencyModel = null;
        try {
            WebCall webCall = new WebCall(WebCall.HttpVerb.GET, UA_BANK_API);
            String response = webCall.execute().getHttpResponseBody();
            Gson gson = new Gson();
            UaBankResponseElement[] currencies = gson.fromJson(response, UaBankResponseElement[].class);
            currencyModel = transformer.backWard(Arrays.asList(currencies));
        } catch (Exception e) {
            //ignore
        }
        return currencyModel;
    }

    @Override
    public void pullCurrency() {
        currencyRepository.save(toCurrency(getCurrency()));
    }

    private Currency toCurrency(CurrencyModel currencyModel){
        return Currency.builder()
                .eurValueBuy(Float.parseFloat(currencyModel.getEurValueBuy()))
                .eurValueSale(Float.parseFloat(currencyModel.getEurValueSale()))
                .usdValueBuy(Float.parseFloat(currencyModel.getUsdValueBuy()))
                .usdValueSale(Float.parseFloat(currencyModel.getUsdValueSale()))
                .build();
    }

}
