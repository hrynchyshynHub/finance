package com.hrnchshn.finance.demon;

import com.hrnchshn.finance.service.currencies.CurrencyProvider;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author ivan.hrynchyshyn
 */
@Component
public class CurrencyUpdater extends RouteBuilder {

    @BeanInject
    private CurrencyProvider currencyProvider;

    @Override
    public void configure() throws Exception {
        from("timer:currencyUpdater?period=3h")
                .log("updating currencies")
                .bean(currencyProvider, "pullCurrency");
    }
}
