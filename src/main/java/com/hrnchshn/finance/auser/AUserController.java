package com.hrnchshn.finance.auser;

import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.dto.CurrencyModel;
import com.hrnchshn.finance.currencies.CurrencyProvider;
import com.hrnchshn.finance.currencies.impl.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping(Api.USER_PATH)
public class AUserController {

    @GetMapping
    public CurrencyModel getUser() throws IOException {
        CurrencyProvider provider = new BankUaCurrencyProvider();
        CurrencyModel currencyModel = provider.getCurrency();
        return currencyModel;
	 }
}
