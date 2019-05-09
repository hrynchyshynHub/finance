package com.hrnchshn.finance.subuz.managers;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ivan.hrynchyshyn
 */
@Component
@Slf4j
public class TelegramSenderProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("Sending telegram message...");
        log.info("MAP: " + Map.class.cast(exchange.getIn().getBody()));
        if (exchange.getIn().getBody() == null) {
            // fail fast
            log.debug("Received exchange with empty body, skipping");
            return;
        }
    }
}
