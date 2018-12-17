package com.hrnchshn.finance.service.currencies;

import com.hrnchshn.finance.dto.CurrencyModel;

import java.io.IOException;

public interface CurrencyProvider {

    CurrencyModel getCurrency() throws IOException;
}
