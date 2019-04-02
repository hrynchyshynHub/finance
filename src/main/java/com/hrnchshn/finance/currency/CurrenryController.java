package com.hrnchshn.finance.currency;

import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.service.currencies.CurrencyProvider;
import com.hrnchshn.finance.service.currencies.dto.CurrencyModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping(Api.CURRENCY_PATH)
public class CurrenryController {

    private final CurrencyProvider currencyProvider;
    private final CurrencyRepository currencyRepository;

    @GetMapping
    public CurrencyModel getCurrency() throws Exception {
        return CompletableFuture
                .supplyAsync(currencyProvider::getCurrency).get();
    }

    @GetMapping("/stat")
    public List<Currency> getCurrencyStatistic() throws Exception {
        return currencyRepository.findAll();
    }
}
