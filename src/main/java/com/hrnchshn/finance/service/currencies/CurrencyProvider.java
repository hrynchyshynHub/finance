package com.hrnchshn.finance.service.currencies;

import com.hrnchshn.finance.service.currencies.dto.CurrencyModel;

import java.io.IOException;

public interface CurrencyProvider {

    CurrencyModel getCurrency();

    void pullCurrency();
}
