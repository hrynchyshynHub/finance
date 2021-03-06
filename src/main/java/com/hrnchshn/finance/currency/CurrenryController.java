package com.hrnchshn.finance.currency;

import com.hrnchshn.finance.auser.AUserRepository;
import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.service.currencies.dto.CurrencyModel;
import com.hrnchshn.finance.service.currencies.CurrencyProvider;
import com.hrnchshn.finance.service.currencies.impl.BankUaCurrencyProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping(Api.CURRENCY_PATH)
public class CurrenryController {

    @Autowired
    private AUserRepository userRepository;

    @GetMapping
    public CurrencyModel getCurrency(Principal principal) throws IOException {
        System.out.println(principal.getName());

        System.out.println(userRepository.findByUsername(principal.getName()));
        CurrencyProvider provider = new BankUaCurrencyProvider();
        return provider.getCurrency();
    }
}
