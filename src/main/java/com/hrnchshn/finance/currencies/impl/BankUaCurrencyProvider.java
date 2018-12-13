package com.hrnchshn.finance.currencies.impl;

import com.google.gson.Gson;
import com.hrnchshn.finance.currencies.CurrencyProvider;
import com.hrnchshn.finance.dto.CurrencyModel;
import com.hrnchshn.finance.dto.UaBankResponseElement;
import com.hrnchshn.finance.transformers.BankUaToCurrencyModelTransformer;
import com.hrnchshn.finance.utils.WebCall;

import java.io.IOException;
import java.util.Arrays;

import static com.hrnchshn.finance.constants.Api.UA_BANK_API;

public class BankUaCurrencyProvider implements CurrencyProvider {

    public CurrencyModel getCurrency() throws IOException {
        try {
            WebCall webCall = new WebCall(WebCall.HttpVerb.GET, UA_BANK_API);
            String response = webCall.execute().getHttpResponseBody();
            Gson gson = new Gson();
            UaBankResponseElement[] currencies = gson.fromJson(response, UaBankResponseElement[].class);
            BankUaToCurrencyModelTransformer transformer = new BankUaToCurrencyModelTransformer();
            CurrencyModel currencyModel = transformer.backWard(Arrays.asList(currencies));
            return currencyModel;
        } catch (Exception e) {
            throw new IOException("Failed connect to url: " + UA_BANK_API);
        }
    }

}
