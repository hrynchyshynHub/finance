package com.hrnchshn.finance.service.currencies.impl;

import com.google.gson.Gson;
import com.hrnchshn.finance.service.currencies.CurrencyProvider;
import com.hrnchshn.finance.service.currencies.dto.CurrencyModel;
import com.hrnchshn.finance.service.currencies.dto.UaBankResponseElement;
import com.hrnchshn.finance.transformers.BankUaToCurrencyModelTransformer;
import com.hrnchshn.finance.utils.WebCall;

import java.util.Arrays;

import static com.hrnchshn.finance.constants.Api.UA_BANK_API;

public class BankUaCurrencyProvider implements CurrencyProvider {

    private BankUaToCurrencyModelTransformer transformer = new BankUaToCurrencyModelTransformer();

    public CurrencyModel getCurrency(){
        CurrencyModel currencyModel = null;
        try {
            WebCall webCall = new WebCall(WebCall.HttpVerb.GET, UA_BANK_API);
            String response = webCall.execute().getHttpResponseBody();
            Gson gson = new Gson();
            UaBankResponseElement[] currencies = gson.fromJson(response, UaBankResponseElement[].class);
            currencyModel = transformer.backWard(Arrays.asList(currencies));
            Thread.sleep(5000);
            return currencyModel;
        } catch (Exception e) {

        }
        return currencyModel;
    }

}
