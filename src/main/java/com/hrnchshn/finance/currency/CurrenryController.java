package com.hrnchshn.finance.currency;

import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.service.currencies.dto.CurrencyModel;
import com.hrnchshn.finance.service.currencies.CurrencyProvider;
import com.hrnchshn.finance.service.currencies.impl.BankUaCurrencyProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(Api.CURRENCY_PATH)
public class CurrenryController {

    @GetMapping
    public CurrencyModel getCurrency() throws IOException {
        CurrencyProvider provider = new BankUaCurrencyProvider();
        return provider.getCurrency();
    }
}
